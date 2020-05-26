package com.redis.cache.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.gui.RedisHomeFrame;
import com.redis.cache.gui.layoutProperty.LoginItemButton;
import com.redis.cache.gui.layoutProperty.LoginPanelProperty;
import com.redis.cache.gui.layoutProperty.Panel;
import com.redis.cache.service.RedisProperty;
import com.redis.cache.service.RedisService;

@Component
public class RedisLoginPanel extends JPanel implements ActionListener {
	
    private static final long serialVersionUID = 1L;

    private LoginPanelProperty loginPanelProperty = new LoginPanelProperty();
    
    @Autowired
    private RedisProperty redisProperty;
    
    private JLabel message, selectCertMessage;
    private JTextField hostText,portText;
    private JCheckBox isSslCheckText;
    private JPasswordField passwordText,certPasswordText;
    private JFileChooser certFile;
    
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
        
        JButton openCertFileButton = new JButton(LoginItemButton.SELECT_FILE.getValue());
        openCertFileButton.setFont(loginPanelProperty.getTextFont());
        openCertFileButton.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(4), 100, loginPanelProperty.getText_height());
        openCertFileButton.setOpaque(true);
        openCertFileButton.setBackground(Color.CYAN);
        //openCertFileButton.setForeground(Color.BLUE); 
        openCertFileButton.setBorder(BorderFactory.createRaisedBevelBorder());
        
        this.add(openCertFileButton);
        
        selectCertMessage = new JLabel("");
        selectCertMessage.setFont(loginPanelProperty.getTextFont());
        selectCertMessage.setBounds(loginPanelProperty.getCurrent_X(2), loginPanelProperty.getCurrent_Y(4), loginPanelProperty.getLabel_width()+50, loginPanelProperty.getText_height());
        this.add(selectCertMessage);
        
        
        //Certification Passowrd password
        JLabel certPasswordLabel = new JLabel("Certification Password");
        certPasswordLabel.setForeground(loginPanelProperty.getLabelFgColor());
        certPasswordLabel.setBackground(loginPanelProperty.getLabelBgColor());
        certPasswordLabel.setFont(loginPanelProperty.getLabelFont());
        certPasswordLabel.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(5), loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(certPasswordLabel);
        
        certPasswordText = new JPasswordField();
        certPasswordText.setFont(loginPanelProperty.getTextFont());
        certPasswordText.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(5), loginPanelProperty.getText_width(), loginPanelProperty.getText_height());
        this.add(certPasswordText);
        
        JButton openBtn = new JButton(LoginItemButton.OPEN_PROFILE.getValue());
        openBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        openBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        openBtn.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(7), 120, 50);
        this.add(openBtn);
        
        // Adding the listeners to components..
        openBtn.addActionListener(this);
        
        JButton saveBtn = new JButton(LoginItemButton.SAVE_PROFILE.getValue());
        saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        saveBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        saveBtn.setBounds(loginPanelProperty.getCurrent_X(1), loginPanelProperty.getCurrent_Y(7), 120, 50);
        this.add(saveBtn);
        
        // Adding the listeners to components..
        saveBtn.addActionListener(this);
        
        
        JButton connectBtn = new JButton(LoginItemButton.CONNECT.getValue());
        connectBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        connectBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        connectBtn.setBounds(loginPanelProperty.getCurrent_X(2), loginPanelProperty.getCurrent_Y(7), 120, 50);
        this.add(connectBtn);
        
        // Adding the listeners to components..
        openCertFileButton.addActionListener(this);
        
        connectBtn.addActionListener(this);
        
        message = new JLabel("");
        message.setBounds(loginPanelProperty.getCurrent_X(0), loginPanelProperty.getCurrent_Y(6),loginPanelProperty.getLabel_width(), loginPanelProperty.getLabel_height());
        this.add(message);

    }

	@Override
    public void actionPerformed(ActionEvent ae) {
    	String actionCommand = ae.getActionCommand();
    	
    	if (actionCommand.equals(LoginItemButton.SELECT_FILE.getValue())) {
    		SearchCertFile();
    	}else if (actionCommand.equals(LoginItemButton.OPEN_PROFILE.getValue())) {
    		OpenProfileFile();
    	}else if (actionCommand.equals(LoginItemButton.SAVE_PROFILE.getValue())) {
    		SaveProfileFile();
    	}else if (actionCommand.equals(LoginItemButton.CONNECT.getValue())) {
    		ConnectService();
    	}
    	
    }
	
    
    @Autowired RedisService redisService;
    
    @SuppressWarnings("deprecation")
	public void ConnectService() {
    	redisProperty.setHost(hostText.getText().trim());
    	redisProperty.setPort(portText.getText().trim());
    	redisProperty.setPassword(passwordText.getText());
    	redisProperty.setSslUsed(isSslCheckText.isSelected());
    	redisProperty.setTrustStorePassword(certPasswordText.getText());
    	if(certFile != null && certFile.getSelectedFile() != null) {
    		redisProperty.setCertPath(certFile.getSelectedFile().getAbsolutePath());
    	}
        if(this.redisProperty.getHost().isEmpty()) {
        	JOptionPane.showMessageDialog(null, "The host cannot be empty");
        }
        else if (this.redisProperty.isSslUsed() && this.redisProperty.getCertPath() == null) {
            JOptionPane.showMessageDialog(null, "Please Select the ssl file");
        } else {     
        	//JOptionPane.showMessageDialog(null, this.redisProperty.toString());
    		if(redisService.ConnectService()) {
    			JOptionPane.showMessageDialog(null, "Connecting Server");
    			this.homeFrame.SwitchPanel(Panel.VIEW_PANEL);
    		}
        }
    }
    
    public void SearchCertFile() {
    	certFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
    	certFile.setAcceptAllFileFilterUsed(false); 
    	certFile.setDialogTitle("Select a cert file"); 
        //FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only . files", "pem"); 
        //certFile.addChoosableFileFilter(restrict); 
        int r = certFile.showOpenDialog(null); 
        if (r == JFileChooser.APPROVE_OPTION) { 
        	selectCertMessage.setText(certFile.getSelectedFile().getAbsolutePath()); 
        	selectCertMessage.setForeground(Color.BLUE);
        } 

    }
    
    public void OpenProfileFile() {
    	JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
    	fileChooser.setAcceptAllFileFilterUsed(false); 
    	fileChooser.setDialogTitle("open a profile file"); 
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .rdf files", "rdf"); 
        fileChooser.addChoosableFileFilter(restrict); 
        int r = fileChooser.showOpenDialog(this.homeFrame); 
        if (r == JFileChooser.APPROVE_OPTION) { 
        	readProfileFile(fileChooser.getSelectedFile());
        } 

    }
    
    public void SaveProfileFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("save a profile file"); 
        int option = fileChooser.showSaveDialog(this.homeFrame);
        if(option == JFileChooser.APPROVE_OPTION){
           File file = fileChooser.getSelectedFile();
           String fileName = file.getName();
		   if (fileName.endsWith(".rdf")) {			   
			   writeProfileFile(file);
		   } else {
		       file = new File(file.toString() + ".rdf");  
		       writeProfileFile(file);
		   }
        }

    }
    
    
	@SuppressWarnings("deprecation")
	public void writeProfileFile(File file) {
    	redisProperty.setHost(hostText.getText().trim());
    	redisProperty.setPort(portText.getText().trim());
    	redisProperty.setPassword(passwordText.getText());
    	redisProperty.setSslUsed(isSslCheckText.isSelected());
    	redisProperty.setTrustStorePassword(certPasswordText.getText());
    	if(certFile != null && certFile.getSelectedFile() != null) {
    		redisProperty.setCertPath(certFile.getSelectedFile().getAbsolutePath());
    	}
		try {
			if (!file.exists()) file.createNewFile();
			FileWriter outFile = new FileWriter(file);
			PrintWriter out = new PrintWriter(outFile, true);
			out.println(StringUtils.join(redisProperty));
			out.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Fail to save profile");
		}

	}
	
	@SuppressWarnings("resource")
	public void readProfileFile(File file) {
		try {
			FileReader fileReader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			fileReader.read(chars);
			String fileContent = new String(chars);
			fileContent = fileContent.substring(15,fileContent.length()-2);
			String[] contentArray = fileContent.split(",");
			String host = contentArray[0].substring(contentArray[0].lastIndexOf("=")+1);
			String port = contentArray[1].substring(contentArray[1].lastIndexOf("=")+1);
			boolean isSslUsed = Boolean.parseBoolean(contentArray[2].substring(contentArray[2].lastIndexOf("=")+1));
			String password = contentArray[3].substring(contentArray[3].lastIndexOf("=")+1);
			String certPath = contentArray[4].substring(contentArray[4].lastIndexOf("=")+1);
			String trustStoreType = contentArray[5].substring(contentArray[5].lastIndexOf("=")+1);
			String trustStorePassword = contentArray[6].substring(contentArray[6].lastIndexOf("=")+1);
			redisProperty.setHost(host);
			redisProperty.setPort(port);
			redisProperty.setSslUsed(isSslUsed);
			redisProperty.setPassword(password);
			redisProperty.setCertPath(certPath);
			redisProperty.setTrustStoreType(trustStoreType);
			redisProperty.setTrustStorePassword(trustStorePassword);
			hostText.setText(host);
			portText.setText(port);
			isSslCheckText.setSelected(isSslUsed);
			passwordText.setText(password);
			selectCertMessage.setText(certPath);
			certPasswordText.setText(trustStorePassword);
						
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to open profile");
		}

	}



}

