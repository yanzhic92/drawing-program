import java.awt.Color;  
import java.io.*;  
import javax.swing.*;  
import javax.swing.filechooser.*;  
//ddddd
public class FileClass {
	 private DrawingWindow drawingwindow;
	 DrawArea drawarea = null; 
	 FileClass(DrawingWindow dw,DrawArea da) {  
	        drawingwindow = dw;  
	        drawarea = da;  
	    }  
	 
	 public void newFile() {  
	        drawarea.setIndex(0);  
	        drawarea.setCurrentChoice(3);
	        drawarea.setStroke(1.0f);
	        drawarea.createNewitem();  
	        drawarea.repaint();  
	    }  
	 
	 public void openFile() {  
	        
	         JFileChooser filechooser = new JFileChooser();  
	         filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
	         
	            int returnVal = filechooser.showOpenDialog(drawingwindow);  
	              
	            if(returnVal == JFileChooser.CANCEL_OPTION) {
	               return;  
	            }  
	            File fileName = filechooser.getSelectedFile();
	            fileName.canRead();  
	            if(fileName == null || fileName.getName().equals(""))
	            {  
	                JOptionPane.showMessageDialog(filechooser,"File Name","please input the file name£¡",JOptionPane.ERROR_MESSAGE);  
	            }  
	              
	            else {  
	                  
	                    try {  
	                        FileInputStream ifs = new FileInputStream(fileName);  
	                        ObjectInputStream input = new ObjectInputStream(ifs);  
	                          
	                        int countNumber = 0;  
	                        Drawing inputRecord;  
	                        countNumber = input.readInt();  
	                        for(int i =0;i<=countNumber;i++)  
	                        {  
	                            drawarea.setIndex(i);  
	                            inputRecord = (Drawing)input.readObject();  
	                            drawarea.DrawList[i] = inputRecord;  
	                        }  
	                        drawarea.createNewitem();  
	                        input.close();  
	                        drawarea.repaint();  
	                    } catch (FileNotFoundException e) {  
	                        JOptionPane.showMessageDialog(drawingwindow,"couldn't find the file£¡","couldn't find the file",JOptionPane.ERROR_MESSAGE);  
	                    } catch (IOException e) {  
	                        JOptionPane.showMessageDialog(drawingwindow,"mistake£¡","mistake",JOptionPane.ERROR_MESSAGE);  
	                    } catch (ClassNotFoundException e) {  
	                        JOptionPane.showMessageDialog(drawingwindow,"couldn't do that£¡","couldn't do that£¡",JOptionPane.ERROR_MESSAGE);  
	                    }  
	                  
	            }  
	    }  
	 public void saveFile() {  
	        // TODO 
	          
	         //JFileChooser 
	        JFileChooser filechooser = new JFileChooser();  
	        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
	        //setFileSelectionMode()
	        int result = filechooser.showSaveDialog(drawingwindow);  
	        if(result == JFileChooser.CANCEL_OPTION){  
	            return ;  
	        }  
	          
	        File fileName = filechooser.getSelectedFile(); 
	        fileName.canWrite();
	        if(fileName == null || fileName.getName().equals(""))
	        {  
	            JOptionPane.showMessageDialog(filechooser,"File Name","please input the file name£¡",JOptionPane.ERROR_MESSAGE);  
	        }  
	        else {  
	            try {  
	                fileName.delete();
	                FileOutputStream fos = new FileOutputStream(fileName+".xxh");

	                ObjectOutputStream output = new ObjectOutputStream(fos);  
	                //Drawing record;  
	                  
	                output.writeInt(drawarea.getIndex());  
	                  
	                for(int i = 0;i<=drawarea.getIndex() ;i++)  
	                {  
	                    Drawing p = drawarea.DrawList[i];  
	                    output.writeObject(p);  
	                    output.flush();   
	                }  
	                output.close();  
	                fos.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  

}
