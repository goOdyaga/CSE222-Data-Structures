import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Retention;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.transform.Templates;

import java.util.Queue;
import java.util.LinkedList;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.SwingUtilities;

public class TreeExample 
{   

    
    

    JFrame f;  
    DefaultMutableTreeNode root=new DefaultMutableTreeNode("root");

    /**
     * Default constructer
     */
    TreeExample()
    {    
          
    }  
    

    /**
     * funstion take an string array and add it to tree
     * @param path path that will be added
     */
    public void addchild(String [] path)
    {
        
        // DefaultMutableTreeNode parent_=new DefaultMutableTreeNode(parent);
        
        addchild(root,path,0);
    }

    private void addchild(DefaultMutableTreeNode localrott,String []path,int index)
    {
        for(int i=0;i<path.length;i++)
        {
            boolean check=true;
            for(int j=0;j<localrott.getChildCount();j++)
            {
                DefaultMutableTreeNode childNodetemp = (DefaultMutableTreeNode)localrott.getChildAt(j);
                if(childNodetemp.getUserObject().toString().equals(path[i]))
                {
                    localrott=childNodetemp;
                    check=false;
                    break;
                }
            }
            if(check)
            {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(path[i]);
                localrott.add(childNode);
                int numberofchild=localrott.getChildCount();
                DefaultMutableTreeNode childNode1=localrott;
                for(int h=0;h<numberofchild;h++)
                    childNode1=(DefaultMutableTreeNode)localrott.getChildAt(h);
                localrott=childNode1;
            }
        }
    }
    /**
     * function that display the tree
     */
    public void displaytree()
    {
        f=new JFrame(); 
        JTree jt=new JTree(root);  
        f.add(jt);  
        f.setSize(200,200);  
        f.setVisible(true); 
    }

    /**
     * print BFS SEARCh steps
     * @param searchingitem item to searched
     * @return if exist return true
     */
    public boolean searchBFS(String searchingitem)
    {
        return searchBFS(root, searchingitem);
    }

    
    /**
     * print DFS SEARCh steps
     * @param searchingitem item to searched
     * @return if exist return true
     */
    public boolean searchDFS(String searchingitem)
    {
        int []index=new int[1];
        index[0]=1;
        return searchDFS(root, searchingitem,index);
    }

    
    /**
     * print postorder SEARCh steps
     * @param searchingitem item to searched
     * @return if exist return true
     */
    public boolean searchpostorder(String searchingitem)
    {
        int []index=new int[1];
        index[0]=1;
        return searchpost(root, searchingitem,index);
    }

    private boolean searchDFS(DefaultMutableTreeNode localroot,String searchingitem,int []index)
    {
        if(localroot==null)
            return false;
        System.out.print("Step "+(index[0]++)+" -> "+localroot.toString());
        if(localroot.toString().equals(searchingitem))
        {
            System.out.println("(Found!)");
            return true;
            
        }
        System.out.println("");

        int chilnumber=localroot.getChildCount();
        int i;
        boolean checK=false;
        for(i=chilnumber-1;i>=0;i--)
        {
            DefaultMutableTreeNode child=(DefaultMutableTreeNode)localroot.getChildAt(i);
            checK=searchDFS(child, searchingitem, index);
            if(checK)
                return checK;
        }
    return false;
    }
    private boolean searchpost(DefaultMutableTreeNode localroot,String searchingitem,int []index)
    {
        if(localroot==null)
            return false;
        

        int chilnumber=localroot.getChildCount();
        int i;
        boolean check=false;
        for(i=0;i<chilnumber;i++)
        {
            DefaultMutableTreeNode child=(DefaultMutableTreeNode)localroot.getChildAt(i);
            check=searchpost(child, searchingitem, index);
            if(check)
                return check;
            System.out.print("Step "+(index[0]++)+" -> "+child.toString());
            if(child.toString().equals(searchingitem))
            {
                System.out.println("(Found!)");
                return true;
            }
        System.out.println("");
        }
    return false;
    }
    private boolean searchBFS(DefaultMutableTreeNode localroot,String searchingitem)
    {
        int []index2=new int[1];
        index2[0]=1;
        int height=root.getDepth();
        int i=0;
        System.out.println("height-> "+height);
        for(i=0;i<=height;i++)
        {
            if(searchNodesAtLevel(localroot, i, searchingitem, index2))
            {
                return true;
            }
        }
    return false;
    }


    private boolean  searchNodesAtLevel(DefaultMutableTreeNode node, int level,String searchingitem,int[] index) {
        if (node == null) {
            return false;
        }
        if (node.getLevel() == level) {
            // Do something with the node at the desired level
            System.out.print("Step "+(index[0]++)+" -> "+node.toString());
            if(node.toString().equals(searchingitem))
            {
                System.out.print("(Found!)\n");
                return true;

            }
            System.out.println("");
                // System.out.println(node.toString());
        }
        boolean check=false;
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            check=searchNodesAtLevel(child, level,searchingitem,index); // ben kucuk bir topum
            if(check)
                return check;
        }
        return false;
    }
    
    /**
     * function that performin move operation
     * @param obj string array that contain path
     * @param addpart string that will be destination
     * @return  if move can be performed funstion return true
     */
    public boolean movepath(String [] obj,String addpart)
    {
        String move_="";
        for(int i=0;i<obj.length;i++)
        {

            move_+=obj[i];
            if(i+1!=obj.length)
            move_+="->";
            

        }
        DefaultMutableTreeNode removepath_=searchpath(root, obj);
        if(removepath_!=null)
        {
            // System.out.println(removepath_.toString());
            int counchild=root.getChildCount();
            for(int i=0;i<counchild;i++)
            {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
                if(child.toString().equals(obj[0]))
                {
                    for(int j=0;j<child.getChildCount();j++)
                    {
                        DefaultMutableTreeNode child2 = (DefaultMutableTreeNode) child.getChildAt(j);
                        if(child2.toString().equals(obj[1]))
                        {
                            removepath_=child2;
                            i=counchild;
                            break;
                        }

                    }

                }
            }
            boolean checkroot=true;
            for(int i=0;i<counchild;i++)
            {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
                if(child.toString().equals(addpart))
                {
                    checkroot=false;
                    String[] newArray = Arrays.copyOfRange(obj, 1, obj.length);
                    DefaultMutableTreeNode movepath__=searchpath(child, newArray);
                    if(movepath__!=null)
                    {
                        // removepath_.removeFromParent();
                        System.out.println("Moved "+move_+ " "+ addpart);
                        System.out.println(move_+" has ben overwritten");
                        remove(obj,root);
                        return true;
                    }
                    else
                    {
                        int depth_=root.getDepth();
                        DefaultMutableTreeNode temp=root;
                        DefaultMutableTreeNode temp2=root;
                        DefaultMutableTreeNode temp3=root;
                        boolean checkchil=false;
                        for(int h=0;h<root.getChildCount();h++)
                        {

                        
                            DefaultMutableTreeNode children=(DefaultMutableTreeNode)temp.getChildAt(h);
                            if(children.toString().equals(addpart))
                            {   
                                for(int k=0;k<children.getChildCount();k++)
                                {
                                    if(children.getChildAt(k).toString().equals(obj[1]))
                                    {
                                        checkchil=true;
                                        temp2=(DefaultMutableTreeNode)children.getChildAt(k);
                                        break;
                                    }
                                }
                                temp=children;
                                break;
                            }  
                            
                        }
                        for(int h=0;h<root.getChildCount();h++)
                        {

                        
                            DefaultMutableTreeNode children=(DefaultMutableTreeNode)root.getChildAt(h);
                            if(children.toString().equals(addpart))
                            {   
                                temp3=children;
                                break;
                            }  
                            
                        }
                        
                        
                        // System.out.println(root.getChildAt(2).getChildCount());
                        DefaultMutableTreeNode chiltoadd=returnPath(root, obj);
                        // System.out.println("111-> "+chiltoadd.toString()+" "+ chiltoadd.getLastLeaf().toString());
                        // for(int z=0;z<root.getChildCount();z++)
                            // System.out.println(root.getChildAt(z).toString()+" -> ");
                        // System.out.println(chiltoadd.toString()+ " "+ chiltoadd.getLastLeaf().toString());
                        if(checkchil)
                        {
                            // System.out.println("-*-> "+temp2.toString());
                            // System.out.println(chiltoadd.getLastLeaf().toString());
                            temp2.removeFromParent();
                        }
                        // System.out.println(root.getChildAt(2).getChildCount());
                        // remove(obj, root);
                        child.add(chiltoadd.getNextNode());
                        remove(obj, root);
                        return true;
                    }
                    
                }
            }
            if(checkroot)
            {
                // System.out.println("->IT WILL ADD");
                // System.out.println(child.toString());
                // String[] newArray_ = Arrays.copyOfRange(obj, 0, obj.length);
                DefaultMutableTreeNode chiltoadd=returnPath(root, obj);
                DefaultMutableTreeNode newroot=new DefaultMutableTreeNode(addpart);
                newroot.add(chiltoadd.getNextNode());
                root.add(newroot);
                remove(obj,root);
                // obj[0]=addpart;
                // addchild(root, obj ,0);

                // System.out.println(root.getChildCount());
            }

            return true;
        }
        
            System.out.println("Cannot move "+move_+" to "+addpart);
            System.out.println("it doesn't exist in tree.");
        
        return false;
        // DefaultMutableTreeNode temp=root;
        // int []index2=new int[1];
        // index2[0]=1;
        // int height=root.getDepth();
        // int i=0;
        // System.out.println("height-> "+height);
        // String path="";
        // DefaultMutableTreeNode movetemp=obj.root.getNextNode();
        // for(i=0;i<=height;i++)
        // {
        //     if(movepath(temp,(DefaultMutableTreeNode)movetemp,i,addpart))
        //     {
        //         return true;
        //     }
        // }
        // for(i=0;i<obj.root.getDepth();i++)
        // {
        //     path+=obj.root.toString();
        //     if(i!=obj.root.getDepth()-1)
        //         path+="->";
        //     movetemp=movetemp.getNextNode();
        // }
        // System.out.println("Cannot move "+path);
        // System.out.println("It doesn't exist in tree");

    // return false;
    }
    private void remove(String [] path,DefaultMutableTreeNode localroot)
    {
        int depth_=localroot.getDepth();
    
        for(int i=0;i<depth_;i++)
        {
            int childnumber=localroot.getChildCount();
            boolean check_=true;
            for(int j=0;j<childnumber;j++)
            {
                DefaultMutableTreeNode child=(DefaultMutableTreeNode)localroot.getChildAt(j);
                // System.out.println("i-> "+i+" child-> "+child.toString()+" path[i] "+path[0]);
                if(i<path.length&&child.toString().equals(path[i]))
                {
                    // System.out.println("ilk kontrol");
                    check_=false;
                    localroot=child;
                    break;
                }

            }
            if(check_)
            {
                // System.out.println("i-> "+i);
                DefaultMutableTreeNode temp=(DefaultMutableTreeNode)localroot.getParent();
                // System.out.println("-*-*> "+localroot.toString());
                // System.out.println("Leaf -> "+root.toString());
                localroot.removeFromParent();
                localroot=temp;
                while(localroot.getChildCount()==0)
                {
                    temp=(DefaultMutableTreeNode)localroot.getParent();
                    localroot.removeFromParent();
                    localroot=temp;
                    // System.out.println("h-> "+localroot.toString());
                }
                return;
            }
        }   
    }

    /**
     * close the the window that display the tree
     */
    public void closewindow()
    {
        f.setVisible(false);
    }

    private DefaultMutableTreeNode searchpath(DefaultMutableTreeNode localRoot,String [] path)
    {
        if(localRoot==null)
            return null;
        if(localRoot.toString().equals(path[0]))
        {
            int depth_=localRoot.getDepth();
            for(int i=0;i<depth_;i++)
            {
                int numberchild=localRoot.getChildCount();
                boolean checK=true;
                for(int j=0;j<numberchild;j++)
                {
                    if(i+1<path.length && path[i+1].equals(localRoot.getChildAt(j).toString()))
                    {
                        checK=false;
                        localRoot=(DefaultMutableTreeNode)localRoot.getChildAt(j);
                        break;
                    }
                    else if(i+1==path.length)
                    {
                        return localRoot;
                    }
                }
                if(numberchild==0)
                    return localRoot;
                if(checK)
                    return null;
            }
            return localRoot;
        }

        int childcount=localRoot.getChildCount();
        for(int i=0;i<childcount;i++)
        {
            DefaultMutableTreeNode child=(DefaultMutableTreeNode)localRoot.getChildAt(i);
            DefaultMutableTreeNode child2=searchpath((DefaultMutableTreeNode)localRoot.getChildAt(i), path);
            if(child2!=null)
                return child;
        }
        return null;
    }  

    private DefaultMutableTreeNode returnPath(DefaultMutableTreeNode localroot,String [] path)
    {
        // boolean checkK_=false;
        // if(path.length==2)
        // {
        //     checkK_=true;
        // }
        DefaultMutableTreeNode returnvalue= new DefaultMutableTreeNode("root2");
        // DefaultMutableTreeNode temp= returnvalue;
        // System.out.println("returnpath test-> "+localroot.toString());
        int depth_=localroot.getDepth();
        System.out.println(localroot.toString());
        int counter=0;
        for(int i=0;i<depth_;i++)
        {

            int count=localroot.getChildCount();
            for(int j=0;j<count;j++)
            {
                DefaultMutableTreeNode child=(DefaultMutableTreeNode)localroot.getChildAt(j);
                if((i+1!=path.length)&&i+1<path.length)
                {
                    if(child.toString().equals(path[i]))
                    {
                        // System.out.println("TRY");
                        // System.out.println("--> ->"+child.toString());
        
                        counter++;
                        DefaultMutableTreeNode newChild=new DefaultMutableTreeNode(child.toString());
                        if(counter!=1)
                        {
                            DefaultMutableTreeNode temper=(DefaultMutableTreeNode)returnvalue.getLastLeaf();
                            // System.out.println("-*-*- *> "+temper.toString());
                            temper.add(newChild);
                        }
                        else
                            returnvalue.add(newChild);
                        localroot=child;
                        break;
                    }

                }
                else
                {
                    if(i<path.length&&child.toString().equals(path[i]))
                    {
                        // System.out.println("->>"+child.toString());
                        DefaultMutableTreeNode temper=(DefaultMutableTreeNode)returnvalue.getLastLeaf();
                        // System.out.println("-?->"+temper.toString());
                        // System.out.println(root.getChildAt(2).getChildCount());
                        DefaultMutableTreeNode temp3=deepCopySubtree(child);
                        temper.add(temp3);
                        // System.out.println(root.getChildAt(2).getChildCount());
                        i=depth_;
                        // System.out.println(returnvalue.getNextNode().toString());
                        // System.out.println(returnvalue.getChildAt(0).toString());
                        return returnvalue.getNextNode();
                    }
        
                }
            }
        }
        return returnvalue;
    }

    private  DefaultMutableTreeNode deepCopySubtree(DefaultMutableTreeNode node) {
        // Create a new node with the same user object as the original node
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node.getUserObject());
    
        // Recursively copy all the children of the original node to the new node
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
            DefaultMutableTreeNode newChildNode = deepCopySubtree(childNode);
            newNode.add(newChildNode);
        }
    
        return newNode;
    }
}




