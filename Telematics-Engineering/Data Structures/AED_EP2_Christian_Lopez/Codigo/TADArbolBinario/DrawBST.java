package TADArbolBinario;

import TADListaDoble.ListaDoble;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Entidad Dibujo de un Árbol Binario de Búsqueda
 * @author Juan Manuel Reyes <juan.reyes@correounivall.edu.co>
 */
public class DrawBST<K extends Comparable<K>,T>{
    protected static final int SIDE  = 30;
    private static final int SPACE   = 10;
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    protected static final Color FILL_COLOR     = Color.LIGHT_GRAY;
    protected static final Color FONT_COLOR     = Color.BLUE;
    private static final Color BORDER_COLOR     = Color.BLACK;
    
    public static <K extends Comparable<K>,T> JFrame draw(final IBSTTree<K,T> tree){
        return draw(tree, "BST");
    }
    
    public static <K extends Comparable<K>,T> JFrame draw(final IBSTTree<K,T> tree, String title){
        DrawBST<K,T> dabb = new DrawBST<K,T>();
        return dabb.drawTree(tree, title);
    }
    
    public JFrame drawTree(final IBSTTree<K,T> tree, String title){
        @SuppressWarnings("serial")
		JFrame window = new JFrame(title){
            @Override
            public void revalidate(){
                int h = getTreeHeight(tree,tree.getRoot());

                setSize(DrawBST.getWidth(h)+SIDE/2, DrawBST.getHeight(h)+SIDE+SPACE);
                setSize(getWidth()+1,getHeight()+1);
                super.revalidate();
                setSize(getWidth()-1,getHeight()-1);
                super.revalidate();
            }
        };
        
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        @SuppressWarnings("serial")
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                setBackground(BACKGROUND_COLOR);
                drawNode(g,tree, tree.getRoot());
            }
        };
        
        int h = getTreeHeight(tree,tree.getRoot());
        
        window.setLayout(new BorderLayout());
        window.add(panel,BorderLayout.CENTER);
        window.setSize(DrawBST.getWidth(h)+SIDE/2, DrawBST.getHeight(h)+SIDE+SPACE);
        window.setVisible(true);
        
        return window;
    }    
    
    private void drawNode(Graphics g, IBSTTree<K,T> tree, IBSTNode<K,T> node){
        if(!tree.isNil(node)){
            int h     = getTreeHeight(tree,node);
            //System.out.println("h:"+h);
            int width = DrawBST.getWidth(h);
            //System.out.println("width:"+width);                
            int y = SPACE;

            drawNode(g, tree, node,0,width,y);
        }
    }

    private void drawNode(Graphics g, IBSTTree<K,T> tree, IBSTNode<K,T> node, int xI, int xF, int y){
        int middle   = (xI+xF)/2;
        int ydestino = y + SIDE + SPACE;

        if(!tree.isNil(node.getLeft())){
            g.setColor(BORDER_COLOR);
            g.drawLine(middle, y+SIDE/2, (xI+middle)/2, ydestino+SIDE/2);
        }
        if(!tree.isNil(node.getRight())){
            g.setColor(BORDER_COLOR);
            g.drawLine(middle, y+SIDE/2, (middle+xF)/2, ydestino+SIDE/2);
        }
        
        fillNode(g,node,middle-SIDE/2, y);
        g.setColor(BORDER_COLOR);
        g.drawOval(middle-SIDE/2, y, SIDE, SIDE);
        String key = node.getKey()+"";
        int ajusteX = (int)((SIDE-key.length()*7)/2)-SIDE/2;
        int ajusteY = SIDE-10;
        
        writeKey(g,node,middle+ajusteX, y+ajusteY,key);
        
        y = ydestino;

        if(!tree.isNil(node.getLeft()))
            drawNode(g,tree,node.getLeft(),xI,middle,y);
        if(!tree.isNil(node.getRight()))
            drawNode(g,tree,node.getRight(),middle,xF,y);
    }
    
    protected void fillNode(Graphics g, IBSTNode<K,T> node, int x, int y){
        g.setColor(FILL_COLOR);
        g.fillOval(x, y, SIDE, SIDE);        
    }
            
    protected void writeKey(Graphics g, IBSTNode<K,T> node, int x, int y, String key){
        g.setColor(FONT_COLOR);
        g.drawString(key, x, y);
    }
            
    private static int getWidth(int h){
        int width = (int)Math.pow(2,h-1);                
        width = width * (SIDE + SPACE);
        return width;
    }
    
    private static int getHeight(int h){
        int height = h*(SIDE + SPACE)+SPACE;
        return height;
    }
    
    private int getTreeHeight(IBSTTree<K,T> tree, IBSTNode<K,T> n){
        if(tree.isNil(n)){
            return 0;
        }else{
            int l = getTreeHeight(tree,n.getLeft());
            int r = getTreeHeight(tree,n.getRight());
            
            int h;
            if(l>r){
                h = l;
            }else{
                h = r;
            }
            //System.out.println("\nkey:"+n.getKey()+", h:"+(h+1));
            return h+1;
        }
    }
}
