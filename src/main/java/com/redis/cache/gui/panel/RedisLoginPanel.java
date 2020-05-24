package com.redis.cache.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.gui.RedisHomeFrame;
import com.redis.cache.gui.layoutProperty.LoginPanelProperty;
import com.redis.cache.gui.layoutProperty.Panel;
import com.redis.cache.service.RedisProperty;

@Component
public class RedisLoginPanel extends JPanel implements ActionListener {
	
    private static final long serialVersionUID = 1L;

    private LoginPanelProperty loginPanelProperty = new LoginPanelProperty();
    
    @Autowired
    private RedisProperty redisProperty;
    
    JLabel message, selectCertMessage;
    JTextField hostText,portText;
    JCheckBox isSslCheckText;
    JFileChooser certFile;
    JPasswordField passwordText;
    
    private RedisHomeFrame homeFrame;
    
    public void InitRedisLoginPanel(RedisHomeFrame homeFrame) {
    	
    	this.homeFrame = homeFrame;
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Redis Client Login");
        titleLabel.setForeground(loginPanelProperty.getTitleColor());
        titleLabel.setFont(loginPanelProperty.getTitleFont());
        titleLabel.setBounds(423, 13, 273, 93);
        this.add(titleLabel);
        
        //host
        JLabel hostLabel = new JLabel("Host");
        hostLabel.setForeground(loginPanelProperty.getLabelFgColor());
        hostLabel.setBackground(loginPanelProperty.getLabelBgColor());
        hostLabel.setFont(loginPanelProperty.getLabelFont());
        hostLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(0), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(hostLabel);

        hostText = new JTextField();
        hostText.setFont(loginPanelProperty.getTextFont());
        hostText.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(0), loginPanelProperty.getText_width(), loginPanelProperty.getText_height());
        this.add(hostText);
        hostText.setColumns(50);
        
        //port
        JLabel portLabel = new JLabel("Port");
        portLabel.setForeground(loginPanelProperty.getLabelFgColor());
        portLabel.setBackground(loginPanelProperty.getLabelBgColor());
        portLabel.setFont(loginPanelProperty.getLabelFont());
        portLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(1), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(portLabel);
        
        portText = new JTextField();
        portText.setFont(loginPanelProperty.getTextFont());
        portText.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(1), loginPanelProperty.getText_width(), loginPanelProperty.getText_height());
        this.add(portText);
        
        
        //password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(loginPanelProperty.getLabelFgColor());
        passwordLabel.setBackground(loginPanelProperty.getLabelBgColor());
        passwordLabel.setFont(loginPanelProperty.getLabelFont());
        passwordLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(2), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setFont(loginPanelProperty.getTextFont());
        passwordText.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(2), loginPanelProperty.getText_width(), loginPanelProperty.getText_height());
        this.add(passwordText);


        //SSL Check
        JLabel isSsLLabel = new JLabel("SSL");
        isSsLLabel.setForeground(loginPanelProperty.getLabelFgColor());
        isSsLLabel.setBackground(loginPanelProperty.getLabelBgColor());
        isSsLLabel.setFont(loginPanelProperty.getLabelFont());
        isSsLLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(3), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(isSsLLabel);
        
        isSslCheckText = new JCheckBox();
        isSslCheckText.setFont(loginPanelProperty.getTextFont());
        isSslCheckText.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(3), loginPanelProperty.getText_width(), loginPanelProperty.getText_height());
        this.add(isSslCheckText);


        //Certification Path
        JLabel certPathLabel = new JLabel("Certification");
        certPathLabel.setForeground(loginPanelProperty.getLabelFgColor());
        certPathLabel.setBackground(loginPanelProperty.getLabelBgColor());
        certPathLabel.setFont(loginPanelProperty.getLabelFont());
        certPathLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(4), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(certPathLabel);
        
        JButton openCertFileButton = new JButton("Select File");
        openCertFileButton.setFont(loginPanelProperty.getTextFont());
        openCertFileButton.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(4), 100, loginPanelProperty.getText_height());
        openCertFileButton.setOpaque(true);
        openCertFileButton.setBackground(Color.CYAN);
        //openCertFileButton.setForeground(Color.BLUE); 
        openCertFileButton.setBorder(BorderFactory.createRaisedBevelBorder());
        
        this.add(openCertFileButton);
        
        selectCertMessage = new JLabel("");
        selectCertMessage.setFont(loginPanelProperty.getTextFont());
        selectCertMessage.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(5), loginPanelProperty.getLabel_width()+50, loginPanelProperty.getText_height());
        this.add(selectCertMessage);
        
        JButton submit = new JButton("Connect");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(loginPanelProperty.getCurrent_X(2), loginPanelProperty.getCurrent_Y(7), 120, 50);
        this.add(submit);
        
        // Adding the listeners to components..
        openCertFileButton.addActionListener(this);
        
        submit.addActionListener(this);
        
        message = new JLabel("");
        message.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(6),loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(message);

    }

	@Override
    public void actionPerformed(ActionEvent ae) {
    	String actionCommand = ae.getActionCommand();
    	
    	if (actionCommand.equals("Select File")) {
    		SearchCertFile();
    	}
    	
    	if (actionCommand.equals("Connect")) {
    		ConnectService();
    	}
    	
    }
	
    public void SearchCertFile() {
    	certFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
    	certFile.setAcceptAllFileFilterUsed(false); 
    	certFile.setDialogTitle("Select a cert file"); 
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .pem files", "pem"); 
        certFile.addChoosableFileFilter(restrict); 
        int r = certFile.showOpenDialog(null); 
        if (r == JFileChooser.APPROVE_OPTION) { 
        	selectCertMessage.setText(certFile.getSelectedFile().getAbsolutePath()); 
        	selectCertMessage.setForeground(Color.BLUE);
        } 
        else {
        	selectCertMessage.setText("*the user cancelled the operation"); 
        	selectCertMessage.setForeground(Color.RED);
        }

    }
    
    
    @SuppressWarnings("deprecation")
	public void ConnectService() {
    	redisProperty.setHost(hostText.getText().trim());
    	redisProperty.setPort(portText.getText().trim());
    	redisProperty.setPassword(passwordText.getText());
    	redisProperty.setSslUsed(isSslCheckText.isSelected());
    	if(certFile != null && certFile.getSelectedFile() != null) {
    		redisProperty.setCertPath(certFile.getSelectedFile().getAbsolutePath());
    	}
        if(this.redisProperty.getHost().isEmpty()) {
        	JOptionPane.showMessageDialog(null, "The host cannot be empty");
        }
        else if(this.redisProperty.getPort().isEmpty()) {
        	JOptionPane.showMessageDialog(null, "The port cannot be empty");
        }
        else if(this.redisProperty.getPassword().isEmpty()) {
        	JOptionPane.showMessageDialog(null, "The password cannot be empty");
        }
        else if (this.redisProperty.isSslUsed() && this.redisProperty.getCertPath() == null) {
            JOptionPane.showMessageDialog(null, "Please Select the ssl file");
        } else {     
        	JOptionPane.showMessageDialog(null, this.redisProperty.toString());
    		JOptionPane.showMessageDialog(null, "Connecting Server");
            this.homeFrame.SwitchPanel(Panel.VIEW_PANEL);
        }
    }


}

