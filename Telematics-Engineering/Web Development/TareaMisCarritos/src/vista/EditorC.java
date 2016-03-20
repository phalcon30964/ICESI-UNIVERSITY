package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class EditorC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNumRefEd;
	private JTextField textFieldModeloEd;
	private JTextField textFieldTipCombEd;
	private JTextField textFieldTipTraccEd;
	private JTextField textFieldTipTrasEd;
	private JTextField textFieldCostoEd;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */

	public JTextField getTextFieldNumRefEd() {
		return textFieldNumRefEd;
	}

	public JTextField getTextFieldCostoEd() {
		return textFieldCostoEd;
	}

	public void setTextFieldCostoEd(JTextField textFieldCostoEd) {
		this.textFieldCostoEd = textFieldCostoEd;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public void setTextFieldNumRefEd(JTextField textFieldNumRefEd) {
		this.textFieldNumRefEd = textFieldNumRefEd;
	}

	public JTextField getTextFieldModeloEd() {
		return textFieldModeloEd;
	}

	public void setTextFieldModeloEd(JTextField textFieldModeloEd) {
		this.textFieldModeloEd = textFieldModeloEd;
	}

	public JTextField getTextFieldTipCombEd() {
		return textFieldTipCombEd;
	}

	public void setTextFieldTipCombEd(JTextField textFieldTipCombEd) {
		this.textFieldTipCombEd = textFieldTipCombEd;
	}

	public JTextField getTextFieldTipTraccEd() {
		return textFieldTipTraccEd;
	}

	public void setTextFieldTipTraccEd(JTextField textFieldTipTraccEd) {
		this.textFieldTipTraccEd = textFieldTipTraccEd;
	}

	public JTextField getTextFieldTipTrasEd() {
		return textFieldTipTrasEd;
	}

	public void setTextFieldTipTrasEd(JTextField textFieldTipTrasEd) {
		this.textFieldTipTrasEd = textFieldTipTrasEd;
	}

	/**
	 * Create the dialog.
	 */
	public EditorC(int numReferencia, int costo, int modelo, String tipoCombustion, String tipoTraccion, String tipoTransmision) {		

		setTitle("Editor de datos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNumeroDeReferencia = new JLabel("Numero de Referencia:");
		
		JLabel lblCosto = new JLabel("Costo:");
		
		JLabel lblModelo = new JLabel("Modelo:");
		
		JLabel lblTippDeCombustion = new JLabel("Tipo de Combustion:");
		
		JLabel lblTipoDetraccion = new JLabel("Tipo de Traccion:");
		
		JLabel lblTipoDeTrasmision = new JLabel("Tipo de Transmision:");
		
		textFieldNumRefEd = new JTextField();
		textFieldNumRefEd.setColumns(10);
		
		textFieldCostoEd = new JTextField();
		textFieldCostoEd.setColumns(10);
		
		textFieldModeloEd = new JTextField();
		textFieldModeloEd.setColumns(10);
		
		textFieldTipCombEd = new JTextField();
		textFieldTipCombEd.setColumns(10);
		
		textFieldTipTraccEd = new JTextField();
		textFieldTipTraccEd.setColumns(10);
		
		textFieldTipTrasEd = new JTextField();
		textFieldTipTrasEd.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumeroDeReferencia)
						.addComponent(lblCosto)
						.addComponent(lblModelo)
						.addComponent(lblTippDeCombustion)
						.addComponent(lblTipoDeTrasmision)
						.addComponent(lblTipoDetraccion))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTipCombEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldModeloEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumRefEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTipTraccEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTipTrasEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCostoEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeReferencia)
						.addComponent(textFieldNumRefEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCosto)
						.addComponent(textFieldCostoEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(textFieldModeloEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTippDeCombustion)
						.addComponent(textFieldTipCombEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDetraccion)
						.addComponent(textFieldTipTraccEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeTrasmision)
						.addComponent(textFieldTipTrasEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		textFieldNumRefEd.setText(""+numReferencia);
		textFieldCostoEd.setText(""+costo);
		textFieldModeloEd.setText(""+modelo);
		textFieldTipCombEd.setText(tipoCombustion);
		textFieldTipTraccEd.setText(tipoTraccion);
		textFieldTipTrasEd.setText(tipoTransmision);
	}
}
