package sonyi.exercise;

/*
	��ϰ������һ���ַ��� str = "a,b,c;d,e,f,g;h,i,j,k,l";  �Ѵ��ַ�����ֳ�һ����ά������ַ���������ӡ������ʽ����(3��)�� �÷���split()
    a b c
    d e f g
    h i j k l
 */
public class Exercise3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a,b,c;d,e,f,g;h,i,j,k,l";
		String[] row = s.split(";");//���ַ������е�һ���и�
		String[][] array = new String[row.length][];//���ٶ�ά�ַ��������пռ�
		
		for(int i = 0; i < row.length; i++){
			array[i] = row[i].split(",");
		}
		
		/*
		for(int i = 0; i < row.length; i++){//������һ���и����ַ�������
			String[] col = row[i].split(",");//���ַ������еڶ����и�
			array[i] = new String[col.length];//���ٶ�ά�ַ��������пռ�
			for(int j = 0; j < col.length; j++){//�����ڶ����и����ַ�������
				//System.out.print(col[j] + " ");//��ӡ����Ԫ��
				array[i][j] = col[j];//������Ԫ�ظ�ֵ����ά�ַ�������
			}
		}
		*/
		
		//��ӡ��ά�ַ�������
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
