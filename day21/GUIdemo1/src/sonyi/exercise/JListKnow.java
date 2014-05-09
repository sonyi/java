package sonyi.exercise;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

/**
 * �������JList��JScrollPane��ͬʹ��
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
        this.setTitle("JList������ʹ�÷�ʽ���Ƽ��ڶ���ʹ�÷�ʽ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jPanelTop = new JPanel();
        jPanelBottom = new JPanel();
        
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jPanelTop,jPanelBottom);
        jSplitPane.setDividerLocation(225);
        
        this.add(jSplitPane);
        
        String[] values = new String[]{"CCCCCC","AAAAAAAA","CCCCCC","DDDDDDD","EEEEEEEEEEEE","FFFFFFFFFFF","HHHHHHHHHHHH"};
        /********************************JList��һ��ʹ�÷�ʽ*************************************/
        jListKnow01 = new JList(values);
        
        //����Ĭ��ѡ����
        jListKnow01.setSelectedIndex(1);
        
        //�õ���ѡ���������
        int index = jListKnow01.getSelectedIndex();//JOptionPane.showMessageDialog(null, index+"����ѡ����");
        int[] indexS = jListKnow01.getSelectedIndices();
        //�õ���ѡ�����ֵ
        String value = (String) jListKnow01.getSelectedValue();
//        String[] svalues = (String[]) jListKnow01.getSelectedValues();
        
        //�����б��ѡ��ģʽ  Ĭ��Ϊ��ѡģʽ
        jListKnow01.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jPanelTop.add(jListKnow01);
        /********************************JList�ڶ���ʹ�÷�ʽ���Ƽ�*************************************/
        /********************************ͨ��ģ�͹����б�********************************/
        //ʵ����ģ��
        DefaultListModel defaultListModel = new DefaultListModel();
        //��ģ�������Ԫ��
        for (int i = 0; i < values.length; i++)
        {
            defaultListModel.addElement(values[i]);
        }
        //ɾ��ģ�������е�Ԫ��
//        defaultListModel.removeAllElements();
        //���������Ƴ�ģ���е�Ԫ�أ����ܻ���Ϊû�и�����������
//        defaultListModel.remove(0);
        //����ֵ�Ƴ�ģ���е�Ԫ�أ�������ڶ����ͬ��ֵ�����Ƴ���һ��������ֵ�����û�У����ᱨ��
        defaultListModel.removeElement("CCCCCC");
        //�滻�ƶ���������Ԫ��
        defaultListModel.setElementAt("������", 1);
        //����ģ��ʵ��������JList
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
