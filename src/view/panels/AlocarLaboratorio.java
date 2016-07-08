package view.panels;

import controller.RequestCheckController;
import labs.LabsRequest;
import view.manager.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class AlocarLaboratorio extends JPanel {

	private static final long serialVersionUID = 1L;
    private JList<LabsRequest> list;
    private RequestCheckController requestController;
    private JLabel lblNumPedido;
    private JLabel lblLaboratorio;
    private JLabel lbPeriodo;
    private JLabel lblDiaSemana;
    private JLabel lblFixo;
    private JLabel lblTurma;

    public AlocarLaboratorio() {
		setLayout(null);
        requestController = new RequestCheckController();

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

		lblNumPedido = new JLabel();
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido.setBounds(460, 162, 375, 27);
		add(lblNumPedido);

        lblLaboratorio = new JLabel();
		lblLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLaboratorio.setBounds(460, 189, 375, 27);
		add(lblLaboratorio);

		lblTurma = new JLabel();
		lblTurma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurma.setBounds(460, 216, 375, 27);
		add(lblTurma);

		lblFixo = new JLabel();
		lblFixo.setBounds(460, 243, 375, 27);
		add(lblFixo);

		lblDiaSemana = new JLabel();
        lblDiaSemana.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDiaSemana.setBounds(460, 270, 375, 27);
        add(lblDiaSemana);

        lbPeriodo = new JLabel();
        lbPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbPeriodo.setBounds(460, 297, 375, 27);
        add(lbPeriodo);

		list = new JList<>(new DefaultListModel<>());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		preencherLista();
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(47, 59, 338, 530);
		add(scroll);
		
		JLabel label = new JLabel();
		label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		label.setBackground(Color.WHITE);
		label.setBounds(450, 150, 399, 184);
		add(label);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.setBounds(450, 452, 89, 27);
		btnAprovar.addActionListener(a -> {
            LabsRequest request = list.getSelectedValue();
            if (request != null){
                requestController.approveReprove(true, request);
                preencherLista();
            }
		});
		add(btnAprovar);

		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setBounds(608, 452, 89, 27);
		btnRecusar.addActionListener(a -> {
            LabsRequest request = list.getSelectedValue();
            if (request != null){
                requestController.approveReprove(true, request);
                preencherLista();
            }
		});
		add(btnRecusar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(760, 452, 89, 27);
		btnVoltar.addActionListener(a -> UIManager.setPanel(new MenuTeste()));
		add(btnVoltar);
	}

	private void preencherLista() {
        limpar();
        for (ListSelectionListener listener: list.getListSelectionListeners()) list.removeListSelectionListener(listener);
		DefaultListModel<LabsRequest> model = (DefaultListModel<LabsRequest>) list.getModel();
		for (int index = model.size() - 1; index >= 0; index--) model.remove(index);
        requestController.listRequests().forEach(model::addElement);
        addListener();
	}

    private void limpar(){
        lblNumPedido.setText("");
        lblLaboratorio.setText("");
        lblTurma.setText("");
        lblFixo.setText("");
        lblDiaSemana.setText("");
        lbPeriodo.setText("");
    }

    public void addListener(){
        list.addListSelectionListener(arg0 -> {
            LabsRequest request = list.getSelectedValue();
            lblNumPedido.setText("Pedido: " + request.getId());
            lblLaboratorio.setText("Laboratório: " + request.getLabs());
            lblTurma.setText("Turma: " + request.getClasses().toString());
            lblFixo.setText("Fixo: " + (request.isFixed()? "Sim": "Não"));
            final String[] dias = {""};
            request.getDays().forEach(dia -> dias[0] += dia + " - ");
            lblDiaSemana.setText("Dias da semana: " + dias[0].substring(0, dias[0].length() - 3));
            List<String> data = request.getDate();
            lbPeriodo.setText(request.isFixed()? "Período: " + data.get(0) + " à " + data.get(1): "");
        });
    }
}
