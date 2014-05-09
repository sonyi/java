package sonyi.exercise;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

/**
 * 本例结合JList和JScrollPane共同使用
 * @author Wfei
 *
 */
public class JListKnow extends JFrame
{
    JList jListKnow01;
    JList jListKnow02;
    JScrollPane jScrollPane02;
    
    JSplitPane jSplitPane;
    JPanel jPanelTop;
    JPanel jPanelBottom;
    public JListKnow()
    {
        this.setBounds(300, 100, 500, 500);
        this.setTitle("JList的两种使用方式：推荐第二种使用方式");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jPanelTop = new JPanel();
        jPanelBottom = new JPanel();
        
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jPanelTop,jPanelBottom);
        jSplitPane.setDividerLocation(225);
        
        this.add(jSplitPane);
        
        String[] values = new String[]{"CCCCCC","AAAAAAAA","CCCCCC","DDDDDDD","EEEEEEEEEEEE","FFFFFFFFFFF","HHHHHHHHHHHH"};
        /********************************JList第一种使用方式*************************************/
        jListKnow01 = new JList(values);
        
        //设置默认选择项
        jListKnow01.setSelectedIndex(1);
        
        //得到已选择项的索引
        int index = jListKnow01.getSelectedIndex();//JOptionPane.showMessageDialog(null, index+"：被选中了");
        int[] indexS = jListKnow01.getSelectedIndices();
        //得到已选择项的值
        String value = (String) jListKnow01.getSelectedValue();
//        String[] svalues = (String[]) jListKnow01.getSelectedValues();
        
        //设置列表的选择模式  默认为多选模式
        jListKnow01.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jPanelTop.add(jListKnow01);
        /********************************JList第二种使用方式：推荐*************************************/
        /********************************通过模型构建列表********************************/
        //实例化模型
        DefaultListModel defaultListModel = new DefaultListModel();
        //向模型中添加元素
        for (int i = 0; i < values.length; i++)
        {
            defaultListModel.addElement(values[i]);
        }
        //删除模型中所有的元素
//        defaultListModel.removeAllElements();
        //根据索引移除模型中的元素，可能会因为没有该索引二报错
//        defaultListModel.remove(0);
        //根据值移除模型中的元素，如果存在多个相同的值，则移除第一个索引的值，如果没有，不会报错
        defaultListModel.removeElement("CCCCCC");
        //替换制定索引处的元素
        defaultListModel.setElementAt("哈哈哈", 1);
        //根据模型实例化出来JList
        jListKnow02 = new JList(defaultListModel);
        
        jScrollPane02 = new JScrollPane(jListKnow02);
        
        jPanelBottom.add(jListKnow02);
    }
    public static void main(String[] args)
    {
        JListKnow jListKnow = new JListKnow();
        jListKnow.setVisible(true);
    }
}
