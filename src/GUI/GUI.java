package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	public static void main(String[] args) {
		
		inicializar();
	}
	
	public static void inicializar() {
		
		// Ventana
		JFrame frame = new JFrame();
		frame.setTitle("GeTicket");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(300, 150, 900, 600);
		JPanel mainContentPanel = new JPanel();
		mainContentPanel.setLayout(new BorderLayout());
		mainContentPanel.setOpaque(true);
		frame.add(mainContentPanel);
		
		// Barra Lateral Izquierda
		JPanel toolPanel = new JPanel();
		toolPanel.setBackground(new Color(24, 43, 73));
		toolPanel.setOpaque(true);
		toolPanel.setBorder(BorderFactory.createLineBorder(new Color(53, 79, 114), 3));
		toolPanel.setPreferredSize(new Dimension(200, 0));
		mainContentPanel.add(toolPanel, BorderLayout.WEST);
		
		// Panel Centro
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.setOpaque(true);
		ScrollPane scrollPane = new ScrollPane();
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		mainContentPanel.add(centerPanel, BorderLayout.CENTER);
		
		// Barra Lateral Derecha
		JPanel ticketPanel = new JPanel();
		ticketPanel.setBackground(new Color(24, 43, 73));
		ticketPanel.setOpaque(true);
		ticketPanel.setBorder(BorderFactory.createLineBorder(new Color(53, 79, 114), 3));
		ticketPanel.setPreferredSize(new Dimension(200, 0));
		mainContentPanel.add(ticketPanel, BorderLayout.EAST);
		
	}
}
