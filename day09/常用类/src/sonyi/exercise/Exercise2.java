package sonyi.exercise;
//��ϰ��
//		��дһ�������������һ���ַ�����ָ���ַ������ֵĴ�����
public class Exercise2 {
	public static void main(String[] args) {
		String s = "251ahebdhelihe odhe lodhehelodehhe";
		String s1 = "he";
		int count = 0;
		int start = 0;
		
		//�жϷ�ʽһ������ʹ��whileѭ������Ϊѭ��û����������
		while(true){	
			int index = s.indexOf(s1,start);//���ز�ѯ���
			if(index != -1){//�ж��Ƿ��ҵ����ҵ���ִ�з�����������ݣ����û�ҵ����˳�ѭ��
				count++;//ÿ�ҵ�һ�Σ����Ӽ�¼һ��
				System.out.println("��" + count + "�γ��ֵ�λ���ǣ�" + index );
				start = index + s1.length();//�ı��´�ѭ������ʼλ��
			}else break;
		}
		
		//�жϷ�ʽ���� forѭ����ͬ����������жϽ��
		/*//��ʼ����һ�β�ѯ��������ж�
		for(int index = s.indexOf(s1);index != -1;){
			count++;  //ÿ�ҵ�һ�Σ����Ӽ�¼һ��
			start = index + s1.length();//�ı��´�ѭ������ʼλ��
			index = s.indexOf("he",start);	//��ѯ�´�ѭ�������������ֵ���������ж�
		}
		*/
		System.out.println("�ַ����У�he���ֵĴ���Ϊ��" + count);
	}
}
