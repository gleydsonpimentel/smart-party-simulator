/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.novaroma.smartpartysimulator.entities.dao;

import br.novaroma.smartpartysimulator.entities.Entity;

/**
 *
 * @author Renato
 */

public interface Dao<T extends Entity> {
	void insert(T entity);
	void delete(String id);
	void update(T entity);
	T search(String id);
}
