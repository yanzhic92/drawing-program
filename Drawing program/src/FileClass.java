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
	                JOptionPane.showMessageDialog(filechooser,"File Name","please input the file name！",JOptionPane.ERROR_MESSAGE);  
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
	                        JOptionPane.showMessageDialog(drawingwindow,"couldn't find the file！","couldn't find the file",JOptionPane.ERROR_MESSAGE);  
	                    } catch (IOException e) {  
	                        JOptionPane.showMessageDialog(drawingwindow,"mistake！","mistake",JOptionPane.ERROR_MESSAGE);  
	                    } catch (ClassNotFoundException e) {  
	                        JOptionPane.showMessageDialog(drawingwindow,"couldn't do that！","couldn't do that！",JOptionPane.ERROR_MESSAGE);  
	                    }  
	                  
	            }  
	    }  
	 public void saveFile() {  
	        // TODO 保存图像  
	          
	         //JFileChooser 为用户选择文件提供了一种简单的机制  
	        JFileChooser filechooser = new JFileChooser();  
	        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
	        //setFileSelectionMode()设置 JFileChooser，以允许用户只选择文件、只选择目录，或者可选择文件和目录。  
	        int result = filechooser.showSaveDialog(drawingwindow);  
	        if(result == JFileChooser.CANCEL_OPTION){  
	            return ;  
	        }  
	          
	        File fileName = filechooser.getSelectedFile();//getSelectedFile()返回选中的文件  
	        fileName.canWrite();//测试应用程序是否可以修改此抽象路径名表示的文件  
	        if(fileName == null || fileName.getName().equals(""))//文件名不存在时  
	        {  
	            JOptionPane.showMessageDialog(filechooser,"File Name","please input the file name！",JOptionPane.ERROR_MESSAGE);  
	        }  
	        else {  
	            try {  
	                fileName.delete();//删除此抽象路径名表示的文件或目录  
	                FileOutputStream fos = new FileOutputStream(fileName+".xxh");//文件输出流以字节的方式输出  
	                //对象输出流  
	                ObjectOutputStream output = new ObjectOutputStream(fos);  
	                //Drawing record;  
	                  
	                output.writeInt(drawarea.getIndex());  
	                  
	                for(int i = 0;i<=drawarea.getIndex() ;i++)  
	                {  
	                    Drawing p = drawarea.DrawList[i];  
	                    output.writeObject(p);  
	                    output.flush();//刷新该流的缓冲。此操作将写入所有已缓冲的输出字节，并将它们刷新到底层流中。  
	                                   //将所有的图形信息强制的转换成父类线性化存储到文件中      
	                }  
	                output.close();  
	                fos.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  

}
