package TadGrafo;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Juan Manuel Reyes <juan.reyes@correounivalle.edu.co>
 */
public class CLDGraph {
    private static int X_COORD = 0;
    private static int Y_COORD = 0;
    protected static final int SIZE_RELOCATION = 40;
    protected static final int SIZE_ARROW_POINT = 10;
    protected static final int MARGIN           = 2;
    protected static final int VERTEX_SIZE      = 30;
    private static final double GROWTH_FACTOR   = 1;
    private static final double OFFSE_ANGLE     = 0;
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    protected static final Color FILL_COLOR     = Color.LIGHT_GRAY;
    protected static final Color FONT_COLOR     = Color.BLUE;
    private static final Color BORDER_COLOR     = Color.BLACK;
    
    public static <T> JFrame draw(IGraph<T> graph){
        return draw(graph,"Graph");
    }
    
    @SuppressWarnings("serial")
	public static <T> JFrame draw(final IGraph<T> graph, String title){
        JFrame window = new JFrame(title){
            @Override
            public void revalidate(){
                int side = windowSize(graph);
                setSize(side, side);
                
                //To the update the size take effect
                setSize(getWidth()+1,getHeight()+1);
                super.revalidate();
                setSize(getWidth()-1,getHeight()-1);
                
                super.revalidate();
            }
        };
        
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel;
        panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                setBackground(BACKGROUND_COLOR);
                drawGraph(g,graph);
                
                //Arrow Examples
                /*
                drawDirectedArrow(g,0,10,90,40,40);
                drawDirectedArrow(g,20,0,70,140);
                drawDirectedArrow(g,125,0,75,140);
                drawDirectedArrow(g,170,140,120,0);
                drawDirectedArrow(g,175,140,225,0);
                drawDirectedArrow(g,120,120,170,170);
                drawDirectedArrow(g,100,100,50,50);
                drawDirectedArrow(g,120,100,170,50);
                drawDirectedArrow(g,100,120,50,170);
                */
            }
        };

        int side = windowSize(graph);
        
        window.setLayout(new BorderLayout());
        window.add(panel,BorderLayout.CENTER);
        window.setSize(side, side);
        window.setVisible(true);
        window.setLocation(X_COORD, Y_COORD);
        
        X_COORD += SIZE_RELOCATION;
        Y_COORD += SIZE_RELOCATION;
        
        return window;
    }
    
    private static <T> void drawGraph(Graphics g, IGraph<T> graph){
        Map<IVertex<T>,Point> coordV = computeCoordinates(graph);
        
        drawEdges(g,coordV,graph);
        drawVertex(g,coordV);
    }
    
    private static <T> void drawEdges(Graphics g, Map<IVertex<T>,Point> coordVertices,  IGraph<T> graph){
    	Iterator<IEdge<T>> edges = graph.getEdges().iterator();
        while(edges.hasNext()){
            IEdge<T> ed = edges.next();
            
            IVertex<T> vi = ed.getInitialVertex();
            IVertex<T> vf = ed.getTerminalVertex();
            
            Point pi = coordVertices.get(vi);
            Point pf = coordVertices.get(vf);
            
            g.setColor(BORDER_COLOR);
            
            if(graph.isDirected()){ //draw arrow
                drawDirectedArrow(g, pi.x, pi.y, pf.x, pf.y, VERTEX_SIZE/2);
            }else{
                g.drawLine(pi.x, pi.y, pf.x, pf.y);
            }
            
            if(graph.isWeighted()){
                int x = pi.x;
                int y = pi.y;
                int difx = (pf.x-pi.x)/2;
                int dify = (pf.y-pi.y)/2;
                x += difx;
                y += dify;
                
                double  weight = ed.getWeight();
                String weigthStr = weight+"";
                if(weight%1==0){
                    weigthStr = ((int)(weight))+"";
                }
                
                g.setColor(FONT_COLOR);
                g.drawString(weigthStr, x, y);
            }
        }
    }
    
    private static <T> void drawVertex(Graphics g, Map<IVertex<T>,Point> coordVertices){
        for (Map.Entry<IVertex<T>,Point> entry : coordVertices.entrySet())
        {
            IVertex<T> v = entry.getKey();
            Point p   = entry.getValue();
            
            int x = p.x - VERTEX_SIZE/2;
            int y = p.y - VERTEX_SIZE/2;
            
            g.setColor(FILL_COLOR);
            g.fillOval(x,y,VERTEX_SIZE,VERTEX_SIZE);
            
            g.setColor(BORDER_COLOR);
            g.drawOval(x,y,VERTEX_SIZE,VERTEX_SIZE);

            int xAdjust = (int)((VERTEX_SIZE-v.getLabel().length()*7)/2)-VERTEX_SIZE/2;
            int yAdjust = VERTEX_SIZE/6;
            
            g.setColor(FONT_COLOR);
            g.drawString(v.getLabel(), p.x+xAdjust, p.y+yAdjust);
        }
    }
    
    private static <T> Map<IVertex<T>,Point> computeCoordinates(IGraph<T> graph){
        
        HashMap<IVertex<T>,Point> coordVertex = new HashMap<>();
        Iterator<IVertex<T>> vertices = graph.getVerticesList().iterator();
        
        int xCenter    = center(graph);
        int yCenter    = xCenter;
        
        int radio      = diameterGraph(graph)/2;
        
        double theta   = 2 * Math.PI / graph.countVertex();
		
        int i = 0;
        
        while(vertices.hasNext()){
            int x = xCenter + (int)(radio*Math.cos(theta * i + OFFSE_ANGLE));
            int y = yCenter + (int)(radio*Math.sin(theta * i + OFFSE_ANGLE));
            
            IVertex<T> vertex = vertices.next();
            coordVertex.put(vertex,new Point(x,y));
            
            i++;
        }
        
        return coordVertex;
    }

    private static <T> int diameterGraph(IGraph<T> graph){
        int cv   = graph.countVertex();
        int size = (int)((cv)*VERTEX_SIZE*GROWTH_FACTOR);
        return size;
    }
    
    private static <T> int canvasSize(IGraph<T> graph){
        int size = diameterGraph(graph)+VERTEX_SIZE*MARGIN;
        return size;
    }
    
    private static <T> int windowSize(IGraph<T> graph){
        int side = canvasSize(graph)+2*VERTEX_SIZE;
        return side;
    }
    
    private static <T> int center(IGraph<T> graph){
        //int center    = canvasSize(graph) / 2 + (MARGIN / 2)*VERTEX_SIZE;
        int center    = canvasSize(graph) / 2;
        return center;
    }
    
    private static Point computePointOnStraightLine(int x, int y, double angle, int large, int xDiff, int yDiff){
        int nx=x;
        int ny;
        
        double slope = Math.tan(angle);
        
        int xAdjust = (int)(large*Math.cos(angle));
        
        if(xDiff<0){
            nx += xAdjust;
        }else{
            nx -= xAdjust;
        }
        if(xAdjust==0){
            if(yDiff<0){
                ny = y+large;
            }else{
                ny = y-large;                
            }
        }else{
            ny = (int)(slope*(nx-x)+y);            
        }

        Point np = new Point(nx,ny);
        return np;
    }
    
    private static void drawDirectedArrow(Graphics g, int x1, int y1, int x2, int y2, int offset){
        int xDiff = x2-x1;
        int yDiff = y2-y1;
        //y = ((y2-y1)/(x2-x1))(x-x1)+y1
        double slope = (double)yDiff/xDiff;
        
        double angle  = Math.atan(slope);
        double angleA = angle + Math.PI/8;
        double angleB = angle - Math.PI/8;
                
        Point iniArrow = new Point(x2,y2);
        if(offset>0){
            iniArrow = computePointOnStraightLine(x2, y2, angle, offset, xDiff, yDiff);
        }
        
        Point a = computePointOnStraightLine(iniArrow.x, iniArrow.y, angleA, SIZE_ARROW_POINT, xDiff, yDiff);
        Point b = computePointOnStraightLine(iniArrow.x, iniArrow.y, angleB, SIZE_ARROW_POINT, xDiff, yDiff);
        
        //g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
        
        //g.setColor(Color.BLUE);
        g.drawLine(iniArrow.x, iniArrow.y, a.x, a.y);
        
        //g.setColor(Color.GREEN);
        g.drawLine(iniArrow.x, iniArrow.y, b.x, b.y);
    }
}
