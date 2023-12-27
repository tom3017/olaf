package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.Dao_wdh;
import com.javalec.function.Dto_wdh;
import com.javalec.product.MainView_Info;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailInfoPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnBucket;
	private JLabel lblId;
	private JLabel lblFile;
	private JButton btnBucket2;
	private JButton btnBuy;
	private JLabel lblNewLabel_2;
	private JTextField tfProductCode;
	private JLabel lblNewLabel_2_1;
	private JComboBox cbQty;
	private JLabel lblNewLabel_2_1_1;
	private JComboBox cbColor;
	private JLabel lblNewLabel_2_1_2;
	private JComboBox cbSize;
	private JLabel lblNewLabel_2_1_2_1;
	private JTextField tfPrice;
	private JComboBox cbEx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetailInfoPage dialog = new DetailInfoPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetailInfoPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				activatedScreen();
				cbQtyNum();
			}
		});
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnBucket());
		{
			JButton btnCustomerUpdate = new JButton("New button");
			btnCustomerUpdate.setBounds(702, 10, 30, 30);
			contentPanel.add(btnCustomerUpdate);
		}
		{
			JButton btnMain = new JButton("메인");
			btnMain.setFont(new Font("굴림", Font.PLAIN, 12));
			btnMain.setBounds(660, 10, 30, 30);
			contentPanel.add(btnMain);
		}
		contentPanel.add(getLblId());
		contentPanel.add(getLblFile());
		contentPanel.add(getBtnBucket2());
		contentPanel.add(getBtnBuy());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getTfProductCode());
		contentPanel.add(getLblNewLabel_2_1());
		contentPanel.add(getCbQty());
		contentPanel.add(getLblNewLabel_2_1_1());
		contentPanel.add(getCbColor());
		contentPanel.add(getLblNewLabel_2_1_2());
		contentPanel.add(getCbSize());
		contentPanel.add(getLblNewLabel_2_1_2_1());
		contentPanel.add(getTfPrice());
	}

	private JButton getBtnBucket() {
		if (btnBucket == null) {
			btnBucket = new JButton("New button");
			btnBucket.setBounds(744, 10, 30, 30);
		}
		return btnBucket;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("로그인이 필요합니다.");
			lblId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblId.setBounds(502, 10, 146, 30);
		}
		return lblId;
	}

	private JLabel getLblFile() {
		if (lblFile == null) {
			lblFile = new JLabel("New label");
			lblFile.setIcon(new ImageIcon(DetailInfoPage.class.getResource("/com/javalec/Imagesample/LGT.png")));
			lblFile.setBackground(new Color(255, 255, 255));
			lblFile.setBounds(45, 35, 400, 400);
		}
		return lblFile;
	}

	private JButton getBtnBucket2() {
		if (btnBucket2 == null) {
			btnBucket2 = new JButton("장바구니");
			btnBucket2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bucketClick();
				}
			});
			btnBucket2.setBounds(150, 465, 200, 50);
		}
		return btnBucket2;
	}

	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("바로구매");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buyClick();
				}
			});
			btnBuy.setBounds(450, 465, 200, 50);
		}
		return btnBuy;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제품명 :");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2.setBounds(424, 100, 100, 30);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfProductCode() {
		if (tfProductCode == null) {
			tfProductCode = new JTextField();
			tfProductCode.setEditable(false);
			tfProductCode.setBounds(536, 101, 112, 30);
			tfProductCode.setColumns(10);
		}
		return tfProductCode;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("수량 :");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2_1.setBounds(424, 160, 100, 30);
		}
		return lblNewLabel_2_1;
	}

	private JComboBox getCbQty() {
		if (cbQty == null) {
			cbQty = new JComboBox();
			cbQty.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cbQty.setBounds(536, 163, 61, 25);
		}
		return cbQty;
	}

	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("색상 :");
			lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2_1_1.setBounds(424, 220, 100, 30);
		}
		return lblNewLabel_2_1_1;
	}

	private JComboBox getCbColor() {
		if (cbColor == null) {
			cbColor = new JComboBox();
			cbColor.setBounds(536, 223, 112, 25);
		}
		return cbColor;
	}

	private JLabel getLblNewLabel_2_1_2() {
		if (lblNewLabel_2_1_2 == null) {
			lblNewLabel_2_1_2 = new JLabel("사이즈 :");
			lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2_1_2.setBounds(424, 280, 100, 30);
		}
		return lblNewLabel_2_1_2;
	}

	private JComboBox getCbSize() {
		if (cbSize == null) {
			cbSize = new JComboBox();
			cbSize.setBounds(536, 283, 82, 25);
		}
		return cbSize;
	}

	private JLabel getLblNewLabel_2_1_2_1() {
		if (lblNewLabel_2_1_2_1 == null) {
			lblNewLabel_2_1_2_1 = new JLabel("가격 :");
			lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_2_1_2_1.setBounds(424, 340, 100, 30);
		}
		return lblNewLabel_2_1_2_1;
	}

	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setBounds(536, 341, 112, 30);
			tfPrice.setColumns(10);
		}
		return tfPrice;
	}

	// --- Method ---

	// 화면이 activated 되었을 때
	private void activatedScreen() {

		int seq = MainView_Info.clickSeq; // seq라는 숫자의 데이터 값 = MainView_Info에서 clickSeq(제품번호)라는 static int를 가져옴
		Dao_wdh dao_wdh = new Dao_wdh(seq); // Dao에 seq를 보냄
//		System.out.println(dao_wdh.viewDetailInfo());	// 잘 가져오는지 실험
		Dto_wdh dto_wdh = dao_wdh.viewDetailInfo();
//		System.out.println(dto_wdh.getPname());			// 잘 출력하는지 실험

		tfProductCode.setText(dto_wdh.getPname()); // 제품명 출력

		tfPrice.setText(Integer.toString(dto_wdh.getPprice())); // 제품 가격 출력

	}

	// cbQty의 재고수량 만들기
	private void cbQtyNum() {
		int seq = MainView_Info.clickSeq; // seq라는 숫자의 데이터 값 = MainView_Info에서 clickSeq(제품번호)라는 static int를 가져옴
		Dao_wdh dao_wdh = new Dao_wdh(seq); // Dao에 seq를 보냄
		Dto_wdh dto_wdh = dao_wdh.viewDetailInfo();
		for (int i = 0; i < dto_wdh.getPqty(); i++) {
			cbQty.addItem(i+1);
		}
	}
	
	
	// 즉시 구매 버튼을 눌렀을 때
	private void buyClick() {
		if (lblId.getText().equals("로그인이 필요합니다.")) {
			JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
		} else {
			int seq = MainView_Info.clickSeq; // seq라는 숫자의 데이터 값 = MainView_Info에서 clickSeq(제품번호)라는 static int를 가져옴
			String num = (String) cbQty.getSelectedItem();
			int stock = currentStock() - Integer.parseInt(num);
			Dao_wdh dao_wdh = new Dao_wdh(seq, stock);
			dao_wdh.updateAction();
		}
	}

	// 현재 재고가 몇개인지 나타내는 function
	private int currentStock() {
		int seq = MainView_Info.clickSeq; // seq라는 숫자의 데이터 값 = MainView_Info에서 clickSeq(제품번호)라는 static int를 가져옴
		Dao_wdh dao_wdh = new Dao_wdh(seq); // Dao에 seq를 보냄
		Dto_wdh dto_wdh = dao_wdh.viewDetailInfo();
		int cStock = dto_wdh.getPqty();
		return cStock;
	}
	
	// 장바구니 버튼을 눌렀을 때
	private void bucketClick() {
		if (lblId.getText().equals("로그인이 필요합니다.")) {
			JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
		} else {
			int seq = MainView_Info.clickSeq; // seq라는 숫자의 데이터 값 = MainView_Info에서 clickSeq(제품번호)라는 static int를 가져옴
			String num = (String) cbQty.getSelectedItem();
			int stock = currentStock() - Integer.parseInt(num);
			Dao_wdh dao_wdh = new Dao_wdh(seq, stock);
			dao_wdh.updateAction();
		}
	}














} // End
