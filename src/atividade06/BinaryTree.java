/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade06;

/**
 *
 * @author RABAH
 */
public class BinaryTree {
    
    Node root;
    String print = "";
    
    public BinaryTree(){
        root = null;
    }
    
    public void addNode(String name){
        boolean check = true;
        Node newNode = new Node(name);
        
        if(root == null){
            root = newNode;
        }else{
        
            Node focusNode = root;
            
            Node parent;
            
            while(check){
                
                parent = focusNode;
                int compare = name.compareToIgnoreCase(focusNode.getName());
                if(compare < 0 ){ // a palavra a ser inserida e menor do pai
                   
                    focusNode = focusNode.getLeftChild(); // troca o pai para o filho do lado esquerda
                    
                    if(focusNode ==null){  // se nao existe um filho a lado esquerdo , o filho seria o que esta sendo inserido
                        parent.setLeftChild(newNode);
                        check = false;
                    }
                }else{
                    
                    //a palavra a ser inserida e maior do que o pai
                    focusNode = focusNode.getRightChild();
                    if(focusNode ==null){
                        if(compare ==0){ 
                            parent.setOccurrence(parent.getOccurrence()+1);
                            newNode.setOccurrence(parent.getOccurrence());
                        }
                       
                        parent.setRightChild(newNode);
                        check =false;
                    }
                }
            }
        }
    }
    
    public void printBinary(Node focusNode){
        
        if(focusNode != null){
            
            printBinary(focusNode.getLeftChild());
            print +=focusNode.toString()+"\n";
            printBinary(focusNode.getRightChild());
        }
       
    }
    public void setPrint(String print){
        this.print = print;
    }
//    @Override
//    public String toString(){
//        String[] content = null;
//        Node focusNode = root;
//        while(focusNode!=null){
//            
//        }
//    }
//    
    public int size(Node focusNode){
        
        if(focusNode ==null){
            return 0;
        }else{
            return size(focusNode.getLeftChild()) +1 + size(focusNode.getRightChild());
        }
        
    }
    
    public int findNode(Node focusNode,String name){
        if(focusNode == null){
            return 0;
        }else{
            int t = 0;
            if(name.compareToIgnoreCase(focusNode.getName())==0) t =1;
            return findNode(focusNode.getLeftChild(),name) + t + findNode(focusNode.getRightChild(),name); 
        }
    }
    public Node getRoot(){
        return this.root;
    }
}
