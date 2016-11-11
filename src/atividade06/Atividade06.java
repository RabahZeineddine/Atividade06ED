/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade06;

import java.awt.Dimension;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author RABAH
 */
public class Atividade06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = buildTree();
        int op = 0;
        do {
            op = menu();
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, binaryTree.size(binaryTree.getRoot()) + " palavras");
                    break;

                case 2:
                    String word = JOptionPane.showInputDialog("Informe a palavra: ");
                    int num = binaryTree.findNode(binaryTree.getRoot(), word);
                    JOptionPane.showMessageDialog(null, (num == 0) ? "Nenhuma palavra encontrada" : (num == 1) ? "Uma palavra encontrada"
                            + "" : num + " palavras encontradas");
                    break;

                case 3:
                    binaryTree.printBinary(binaryTree.getRoot());
                    JTextArea textArea = new JTextArea(binaryTree.print);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, "Aravore Binaria",
                            JOptionPane.DEFAULT_OPTION);
                    binaryTree.setPrint("");

            }

        } while (op != 0);
       
        
//        System.out.println(binaryTree.size(binaryTree.getRoot()));
//        System.out.println(binaryTree.findNode(binaryTree.getRoot(), "w"));

    }

    public static int menu() {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1-Contador - Numero total das palavras.\n2-Busca por palavra\n3- Imprimir arvore\n0- Sair"));

        return op;
    }
//    
//    public static void build(BinaryTree tree,String content,int i,String word){
//        char c = content.charAt(i);
//        if(c != ' ' && c != ',' && c != '.')
//    }

    public static BinaryTree buildTree() {
        File file = new File("input.txt");
        if (!file.exists()) {
            System.out.println("arquivo nao encontrado!");
        }

        String input = Util.readTextFromFile(file);
        BinaryTree binaryTree = new BinaryTree();

        String word = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != ',' && c != '.' && c!='-') {
                word += c;
            } else {
                binaryTree.addNode(word);
                word = "";
            }
        }
        return binaryTree;
    }

}
