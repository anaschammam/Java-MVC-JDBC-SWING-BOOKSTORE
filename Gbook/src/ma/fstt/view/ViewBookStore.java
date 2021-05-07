package ma.fstt.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ma.fstt.dao.Base_BookStore;
import ma.fstt.model.BookStore;
import org.eclipse.swt.widgets.Button;

public class ViewBookStore {
	private Base_BookStore pm=new Base_BookStore();

	protected Shell shell;
	private Table table;
	private Text text_Id_BS;
	private Text text_name_BS;
	private Text text_adresse;
	private Text text_email;
	private Text text_telephone;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewBookStore window = new ViewBookStore();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void fillData() {
		 table.removeAll();
			for(BookStore p : pm.getAll()) {
				TableItem tableItem=new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] 
						{
								String.valueOf(p.getId_bookstore()),p.getName(),p.getAddresse(),p.getEmail(),p.getTelephone()
				});
			}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		fillData();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		fillData() ;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			 TableItem[] selection=table.getSelection();
			 int id=Integer.parseInt(selection[0].getText());
			 BookStore mybookstore=pm.getOne(id);
			 text_Id_BS.setText(String.valueOf(mybookstore.getId_bookstore()));
			 text_name_BS.setText(mybookstore.getName());
			 text_adresse.setText(mybookstore.getAddresse());
			 text_email.setText(mybookstore.getEmail());
			 text_telephone.setText(mybookstore.getTelephone());
			

			
			 
			}
		});
		table.setBounds(10, 10, 424, 103);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn clmnId_Bookstore = new TableColumn(table, SWT.NONE);
		clmnId_Bookstore.setWidth(57);
		clmnId_Bookstore.setText("id_BS");
		
		TableColumn clmn_NameBS = new TableColumn(table, SWT.NONE);
		clmn_NameBS.setWidth(80);
		clmn_NameBS.setText("NameBS");
		
		TableColumn clmnAdresse = new TableColumn(table, SWT.NONE);
		clmnAdresse.setWidth(83);
		clmnAdresse.setText("Adresse");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {"ana hna"});
		tableItem.setText("New TableItem");
		
		TableColumn ColumnEmail = new TableColumn(table, SWT.NONE);
		ColumnEmail.setWidth(100);
		ColumnEmail.setText("email");
		
		TableColumn Columntelephone = new TableColumn(table, SWT.NONE);
		Columntelephone.setWidth(100);
		Columntelephone.setText("telephone");
		
		Label Labelid_BS = new Label(shell, SWT.NONE);
		Labelid_BS.setBounds(10, 119, 70, 17);
		Labelid_BS.setText("id_BS");
		
		text_Id_BS = new Text(shell, SWT.BORDER);
		text_Id_BS.setBounds(85, 119, 83, 22);
		
		Label LabelAdresse = new Label(shell, SWT.NONE);
		LabelAdresse.setBounds(10, 169, 70, 17);
		LabelAdresse.setText("Adresse");
		
		text_name_BS = new Text(shell, SWT.BORDER);
		text_name_BS.setBounds(85, 147, 83, 22);
		
		Label LabelnameBS_1 = new Label(shell, SWT.NONE);
		LabelnameBS_1.setText("nameBS");
		LabelnameBS_1.setBounds(10, 142, 70, 17);
		
		text_adresse = new Text(shell, SWT.BORDER);
		text_adresse.setBounds(85, 175, 83, 22);
		
		text_email = new Text(shell, SWT.BORDER);
		text_email.setBounds(85, 203, 83, 22);
		
		text_telephone = new Text(shell, SWT.BORDER);
		text_telephone.setBounds(85, 231, 83, 22);
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setText("email");
		lblEmail.setBounds(10, 208, 70, 17);
		
		Label LabelTelephone = new Label(shell, SWT.NONE);
		LabelTelephone.setText("telephone");
		LabelTelephone.setBounds(10, 236, 70, 17);
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BookStore p=new BookStore();
				p.setId_bookstore(Integer.parseInt(text_Id_BS.getText()));
				p.setName(text_name_BS.getText());
				p.setAddresse(text_adresse.getText());
				p.setEmail(text_email.getText());
				p.setTelephone(text_telephone.getText());
				
				if(pm.save(p)) 
				{
					JOptionPane.showMessageDialog(null, "add succefully");
					

				}
				else JOptionPane.showMessageDialog(null, "failed");
				 table.clearAll();
				 fillData();
			}
		});
		btnSave.setBounds(196, 117, 97, 34);
		btnSave.setText("Save");
		
		Button btnUpdate = new Button(shell, SWT.NONE);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BookStore p=new BookStore();
				p.setId_bookstore(Integer.parseInt(text_Id_BS.getText()));
				p.setName(text_name_BS.getText());
				p.setAddresse(text_adresse.getText());
				p.setEmail(text_email.getText());
				p.setTelephone(text_telephone.getText());
				
				if(pm.update(p)) 
				{
					JOptionPane.showMessageDialog(null, "Update succefully");
					
				}
				else JOptionPane.showMessageDialog(null, "failed while updating");
				table.clearAll();
				 fillData();
			}
		});
		btnUpdate.setBounds(196, 169, 97, 34);
		btnUpdate.setText("Update");
		
		Button btnShow = new Button(shell, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.clearAll();
				 fillData();
			}
			
		});
		btnShow.setBounds(299, 119, 97, 34);
		btnShow.setText("Show");
		
		Button btnDelete = new Button(shell, SWT.NONE);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int result =JOptionPane.showConfirmDialog(null, "are you sure?","confirme",JOptionPane.YES_NO_CANCEL_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					TableItem[] selection=table.getSelection();
					int id=Integer.parseInt(selection[0].getText());
					 BookStore p=pm.getOne(id);
					 table.clearAll();
					 pm.delete(p);
					 fillData();
			}
		}});
		btnDelete.setBounds(299, 169, 97, 34);
		btnDelete.setText("Delete");

	}

}
