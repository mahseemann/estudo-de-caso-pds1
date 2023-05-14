package visao;

import javax.swing.JFrame;

import java.awt.event.ActionListener;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	public TelaInicial() {
        setTitle("rolê");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("role/src/visao/Logo.png").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("ins 0, wrap 1", "[500px,grow]", "[grow][grow][372px,grow]"));
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setVgap(10);
        flowLayout.setHgap(20);
        contentPane.add(panel, "cell 0 0,grow");
        
		panel.setBackground(Color.BLACK);
		panel.setMinimumSize(new Dimension(Integer.MIN_VALUE, 75));
		
		JLabel lblNewLabel = new JLabel("rolê");
		lblNewLabel.setFont(new Font("SF Pro Display", Font.BOLD, 38));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, "cell 0 1 1 2,grow");
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
//		scrollPane.setViewportBorder(null);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel panel_2 = new EventoItemView("✨", "Rolê na fac", "23 de maio • 7 participantes");
		JPanel panel_3 = new EventoItemView("🌱", "Churrasco vegano", "06 de junho • 15 participantes");
		JPanel panel_4 = new EventoItemView("🎡", "Parque de diversões", "12 de junho • 3 participantes");
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		panel_1.add(panel_4);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setOpaque(false);
//        contentPane.add(panelBotoes, "cell 0 2,grow");

		JButton btnCadastrarInsumo = new JButton("Cadastrar Insumo 🪩");
		btnCadastrarInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastroInsumo();
			}
		});
		panelBotoes.add(btnCadastrarInsumo);

		JButton btnCadastrarEvento = new JButton("Cadastrar Evento");
		btnCadastrarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastroEvento();
			}
		});
		panelBotoes.add(btnCadastrarEvento);

		setVisible(true);
	}

	private void abrirTelaCadastroInsumo() {
		InsumoView telaDeInsumo = new InsumoView();
		telaDeInsumo.setVisible(true);
	}

	private void abrirTelaCadastroEvento() {
		TelaEventos telaDeEventos = new TelaEventos();
		telaDeEventos.setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.version"));
		TelaInicial tela = new TelaInicial();
		tela.setVisible(true);
	}
}
