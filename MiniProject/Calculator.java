import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
class Calculator extends Frame implements WindowListener, ActionListener
{	
	private Label dispL, inputL;
	private JButton[] button;  //18개
	StringBuffer sb= new StringBuffer();
	DecimalFormat df= new DecimalFormat("#,##0.###############");  //소숫점 이하 15자리까지 표현
	
	public double number;

	public Calculator(){
		super("미니 계산기");

		Panel whole = new Panel();  //전체
	    Panel p1 = new Panel();  
	    Panel p2 = new Panel();  
		Panel p3 = new Panel(); 
		Panel p4 = new Panel();
		Panel p5 = new Panel(); 
		Panel p6 = new Panel();
		Panel p7 = new Panel();
		
		//.....버튼
		String[] buttonName = {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+","Back","C"};
		button = new JButton[18];
		for(int i=0;i<18;i++){
			 button[i]=new JButton(buttonName[i]);
		}
		
		//....라벨
		dispL= new Label("0",Label.RIGHT);
		dispL.setBackground(new Color(139,158,226));
		inputL= new Label("0", Label.RIGHT);
		inputL.setBackground(new Color(139,158,226));
		
		//....패널
		whole.setLayout(new GridLayout(7,1,5,5));
		p1.setLayout(new GridLayout(1,1,5,5));
		p1.add(dispL);
		p2.setLayout(new GridLayout(1,1,5,5));
		p2.add(inputL);
		p3.setLayout(new GridLayout(1,2));
		p3.add(button[16]);
		p3.add(button[17]);
		p4.setLayout(new GridLayout(1,4));
		for(int i=0;i<4;i++) { p4.add(button[i]); }
		p5.setLayout(new GridLayout(1,4));
		for(int i=4;i<8;i++) { p5.add(button[i]); }
		p6.setLayout(new GridLayout(1,4));
		for(int i=8;i<12;i++) { p6.add(button[i]); }
		p7.setLayout(new GridLayout(1,4));
		for(int i=12;i<16;i++) { p7.add(button[i]);	}
		whole.add(p1);
		whole.add(p2);
		whole.add(p3);
		whole.add(p4);
		whole.add(p5);
		whole.add(p6);
		whole.add(p7);
		add("Center", whole);
		//...윈도우 창 설정
		setBounds(900,180,350,500);
		setBackground(new Color(105,132,224));
		setVisible(true);
		//...이벤트 설정
		for(int i=0;i<18;i++){ button[i].addActionListener(this); }
		this.addWindowListener(this);
	}

		//...actionPerFormed 이벤트
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="1"){ sb.append(1); } 
			else if(e.getActionCommand()=="2"){ sb.append(2); }
			else if(e.getActionCommand()=="3"){ sb.append(3); }
			else if(e.getActionCommand()=="4"){ sb.append(4); }
			else if(e.getActionCommand()=="5"){ sb.append(5); }
			else if(e.getActionCommand()=="6"){ sb.append(6); }
			else if(e.getActionCommand()=="7"){ sb.append(7); }
			else if(e.getActionCommand()=="8"){ sb.append(8); }
			else if(e.getActionCommand()=="9"){ sb.append(9); }
			else if(e.getActionCommand()=="0"){ sb.append(0); }
			else if(e.getActionCommand()=="C"){ sb.delete(0,sb.length()); }
			else if(e.getActionCommand()=="Back"){ 
				if(sb.length()>0) sb=sb.delete(sb.length()-1,sb.length());
				else sb.delete(0,sb.length());
			}
			else if(e.getActionCommand()=="."){ 
				if(sb.indexOf(".")==-1){
					if(inputL.getText().equals("0")){
						sb.append("0.");
					} else{
						sb.append(".");
					}
				} 
			}
			//...StringBuffer의 값을 임시로 담을 temp 변수
			String temp;
			//...StringBufferd 안에 있는 값이 존재하는지 여부를 체크
			if(sb.length()>0){
				//StringBuffer 안에 소수점이 있을 떄(소수점을 기준으로 앞의 정수부분을 decimalFormat진행)
				if(sb.indexOf(".")==sb.length()-1){
					temp=sb.substring(0,sb.indexOf("."));
					temp=df.format(Integer.parseInt(temp));
					temp+=".";
					inputL.setText(temp);
				} else {
					temp=sb.toString();
					temp=df.format(Double.parseDouble(temp));
					inputL.setText(temp);
				}
			} else inputL.setText("0");
		}

		//...windowListener의 추상메소드
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){} //창을 닫은 뒤 사후처리
		public void windowClosing(WindowEvent e){ System.exit(0); }  //x를 누르는 시정
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}

	public static void main(String[] args) 
	{
		Calculator c = new Calculator();
		
	}
}
