package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;


public class Arvore {

    private NoArvore root = null;
    private String dataTree = "";
    private int quantity;

    public Arvore() {
        root = null;
    }
    
     public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public NoArvore getRoot() {
        return root;
    }

    public void setRoot(NoArvore root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return getRoot() == null;
    }

    public NoArvore getRootNode() {
        return getRoot();
    }

    private static int height(NoArvore link) {  //Retorna altura do no.

        if (link == null) {
            return -1;
        } else {
            return link.getHeight();
        }
    }

    private static int max(int lhs, int rhs) { //Retorna o maior valor ente lhs e rhs.

        if (lhs > rhs) {
            return lhs;
        } else {
            return rhs;
        }
    }

    private int getFactor(NoArvore link) { //Retorna o fator de balanceamento da árvore com raiz passada como parametro.
        return height(link.getLeft()) - height(link.getRight());
    }

    public boolean insert(Entity entity) {
        setRoot(insert(entity, getRoot()));
        
        return true;
    }

    private NoArvore insert(Entity entity, NoArvore link) {

        if (link == null) {
            link = new NoArvore(entity);
            quantity++;
        } 
        else if (entity.getId().compareTo(link.getEntity().getId()) < 0) {
            link.setLeft(insert(entity, link.getLeft()));
        } 
        else if (entity.getId().compareTo(link.getEntity().getId()) > 0) {
            link.setRight(insert(entity, link.getRight()));
        }
       
        link = balance(link);

        return link;
    }

    public NoArvore balance(NoArvore link) {

        if (getFactor(link) == 2) {
            if (getFactor(link.getLeft()) > 0) 
                link = doRightRotation(link);
            else 
                link = doDoubleRightRotation(link);
        } 
        else if (getFactor(link) == -2) {
            if (getFactor(link.getRight()) < 0) 
                link = doLeftRotation(link);
            else 
                link = doDoubleLeftRotation(link);
        }

        link.setHeight(max(height(link.getLeft()), height(link.getRight())) + 1);

        return link;
    }

    private static NoArvore doRightRotation(NoArvore link2) {

        NoArvore link1 = link2.getLeft();
        
        link2.setLeft(link1.getRight());
        link1.setRight(link2);
        
        link2.setHeight(max(height(link2.getLeft()), height(link2.getRight())) + 1);
        link1.setHeight(max(height(link1.getLeft()), link2.getHeight()) + 1);

        return link1;
    }

    private static NoArvore doLeftRotation(NoArvore link1) {

        NoArvore link2 = link1.getRight();
        
        link1.setRight(link2.getLeft());
        link2.setLeft(link1);
        
        link1.setHeight(max(height(link1.getLeft()), height(link1.getRight())) + 1);
        link2.setHeight(max(height(link2.getRight()), link1.getHeight()) + 1);

        return link2;
    }

    private static NoArvore doDoubleRightRotation(NoArvore link) {
        link.setLeft(doLeftRotation(link.getLeft()));

        return doRightRotation(link);
    }

    private static NoArvore doDoubleLeftRotation(NoArvore link) {
        link.setRight(doRightRotation(link.getRight()));

        return doLeftRotation(link);
    }

    public NoArvore search(String id) {
        return search(getRoot(), id);
    }

    private NoArvore search(NoArvore temp, String id) {

        while (temp != null) {
            if (id.equalsIgnoreCase(temp.getEntity().getId())) {
                return temp;
            } else if (id.compareToIgnoreCase(temp.getEntity().getId()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        //Caso nao encontre, retona null.
        return null;
    }

    public String inorder() {
        return inorder(getRoot());
    }

    private String inorder(NoArvore temp) {

        if (temp != null) {
            inorder(temp.getLeft());
            dataTree += temp.getEntity().getId() + " ";
            inorder(temp.getRight());
        }

        return dataTree;
    }

    public void preorder() {
        preorder(getRoot());
    }

    private void preorder(NoArvore temp) {

        if (temp != null) {
            System.out.print(temp.getEntity().getId() + " ");
            preorder(temp.getLeft());
            preorder(temp.getRight());
        }
    }

    public void postorder() {
        postorder(getRoot());
    }

    private void postorder(NoArvore temp) {

        if (temp != null) {
            postorder(temp.getLeft());
            postorder(temp.getRight());
            System.out.print(temp.getEntity().getId() + " ");
        }
    }

    public void update(Entity entity) {

        NoArvore temp = getRoot();

        while (temp != null) {
            if (entity.getId().equalsIgnoreCase(temp.getEntity().getId())) {
                temp.setEntity(entity);
            } else if (entity.getId().compareToIgnoreCase(temp.getEntity().getId()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
    }
    
    public void delete(String id) {
        Entity entity = search(id).getEntity();
        deleteLink(getRoot(), entity);
    }
    
    private NoArvore deleteLink(NoArvore root, Entity entity) {
		
        if (root == null) {
            return root;
        }
        
        if (quantity == 1) {
            this.root = null;
            quantity--;
        }
        else if (entity.getId().compareTo(root.getEntity().getId()) < 0) {
            root.setLeft(deleteLink(root.getLeft(), entity));
        } 

        else if (entity.getId().compareTo(root.getEntity().getId()) > 0) {
            root.setRight(deleteLink(root.getRight(), entity));
        } 
         
        //if key is same as root's key, then this is the node to be deleted
        else {
            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                NoArvore temp = null;
                
                if (temp == root.getLeft()) {
                    temp = root.getRight();
                } 
                else {
                    temp = root.getLeft();
                }
 
                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } 
                // One child case
                else {
                    root = temp; // Copy the contents of the non-empty child
                }
            } 
            else {
 
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
            	NoArvore temp = lowerValue(root.getRight());
 
                // Copy the inorder successor's data to this node
                root.setEntity(temp.getEntity()); //MODIFIQUEI E NAO SEI SE ESTA CORRETO
 
                // Delete the inorder successor
                root.setRight(deleteLink(root.getRight(), temp.getEntity()));
            }
            quantity--;
        }
 
        // If the tree had only one node then return
        if (root == null) {
            return root;
        }
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getFactor(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getFactor(root.getLeft()) >= 0) {
            return doRightRotation(root);
        }
 
        // Left Right Case
        if (balance > 1 && getFactor(root.getLeft()) < 0) {
            root.setLeft(doLeftRotation(root.getLeft()));
            return doRightRotation(root);
        }
 
        // Right Right Case
        if (balance < -1 && getFactor(root.getRight()) <= 0) {
            return doLeftRotation(root);
        }
 
        // Right Left Case
        if (balance < -1 && getFactor(root.getRight()) > 0) {
            root.setRight(doRightRotation(root.getRight()));
            return doLeftRotation(root);
        }
 
        return root;
    }
	
	/* Given a non-empty binary search tree, return the node with minimum
    key value found in that tree. Note that the entire tree does not
    need to be searched. */
   private NoArvore lowerValue(NoArvore link) {
	   NoArvore current = link;

       /* loop down to find the leftmost leaf */
       while (current.getLeft() != null) {
           current = current.getLeft();
       }

       return current;
   }
}
