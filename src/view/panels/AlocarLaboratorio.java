package view.panels;

import controller.RequestCheckController;
import labs.LabsRequest;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.*;

public class AlocarLaboratorio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<LabsRequest> list;
	private List<LabsRequest> requests;
	private RequestCheckController requestController;

	public AlocarLaboratorio() {
		setLayout(null);

		JLabel lblListaDePedidos = new JLabel("Lista de pedidos");
		lblListaDePedidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePedidos.setBounds(47, 28, 338, 32);
		add(lblListaDePedidos);

		JLabel lblInformacoesDoPedido = new JLabel("Informações do pedido");
		lblInformacoesDoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacoesDoPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformacoesDoPedido.setBounds(450, 128, 364, 23);
		add(lblInformacoesDoPedido);

		JLabel lblNumPedido = new JLabel("");
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido.setBounds(460, 162, 375, 27);
		add(lblNumPedido);

		JLabel lblLaboratorio = new JLabel("");
		lblLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLaboratorio.setBounds(460, 189, 375, 27);
		add(lblLaboratorio);

		JLabel lblTurma = new JLabel("");
		lblTurma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurma.setBounds(460, 216, 375, 27);
		add(lblTurma);

		JLabel lblFixo = new JLabel("");
		lblFixo.setBounds(460, 243, 375, 27);
		add(lblFixo);

		JLabel lblDiaSemana = new JLabel("");
		lblDiaSemana.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiaSemana.setBounds(460, 270, 375, 27);
		add(lblDiaSemana);

		list = new JList<LabsRequest>(new DefaultListModel<LabsRequest>());
		preencherLista();
		list.addListSelectionListener(arg0 -> {
			LabsRequest request = list.getSelectedValue();
			lblNumPedido.setText("Pedido: " + "");
			lblLaboratorio.setText("Laboratório: " + "");
			lblTurma.setText("Turma: " + "");
			lblFixo.setText("Fixo: " + "");
			lblDiaSemana.setText("Dias da semana: " + "");
		});
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(47, 59, 338, 530);
		add(scroll);
		
		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label.setBackground(Color.WHITE);
		label.setBounds(450, 150, 399, 157);
		add(label);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.setBounds(450, 452, 89, 27);
		btnAprovar.addActionListener(a -> {
			preencherLista();
		});
		add(btnAprovar);

		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setBounds(608, 452, 89, 27);
		btnRecusar.addActionListener(a -> {
			preencherLista();
		});
		add(btnRecusar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(760, 452, 89, 27);
		btnVoltar.addActionListener(a -> {

		});
		add(btnVoltar);
	}

	private void preencherLista() {
		requests = requestController.listRequests();
		DefaultListModel<LabsRequest> model = (DefaultListModel<LabsRequest>) list.getModel();
		model.removeAllElements();
		requests.forEach(model::addElement);
	}
}
