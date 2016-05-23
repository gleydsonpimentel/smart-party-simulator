/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.novaroma.smartpartysimulator.entities.dao;

import br.novaroma.smartpartysimulator.entities.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Renato
 */
public class DaoImpl<T extends Entity> implements Dao<T> {
  private Class currentClass;

    public DaoImpl(Class<T> currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public void insert(T entity) {
        save(entity);
    }

    @Override
    public void delete(String id){

        File folder = getFolder();
        File file = new File(folder, id + ".data");

        if (!file.exists()) {
            //exception here
        } else {
            file.delete();
        }
    }

    @Override
    public void update(T entity) {
        save(entity);
    }

    @Override
    public T search(String id) {

        T entity = null;
        File folder = getFolder();

        File file = new File(folder, id);

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            entity = (T) ois.readObject();

        } catch (Exception ex) {
            //TODO 
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    //TODO
                }
            }
        }

        return entity;
    }

    public void save(T entity) {

        File folder = getFolder();
        File file = new File(folder, entity.getId() + ".data");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(entity);

        } catch (Exception ex) {
            //TODO
        } finally {
            if (oos != null) {
                try {

                    oos.close();

                } catch (IOException ex) {
                    //TODO
                }
            }
        }
    }

    public File getFolder() {

        String getClassName = "\\Projeto\\" + currentClass.getSimpleName();

        File file = new File(getClassName);

        file.mkdirs();

        return file;
    }
    
}
