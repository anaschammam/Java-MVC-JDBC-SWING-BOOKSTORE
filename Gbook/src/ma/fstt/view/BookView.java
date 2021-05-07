package ma.fstt.view;
import ma.fstt.dao.BaseBook;
import ma.fstt.model.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;



import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BookView {

	protected Shell shell;
	private Table table;
	private BaseBook pm=new BaseBook();
	private Text textId_Book;
	private Text textNameBook;
	private Text textAuteur;
	private Text textAnnee;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BookView window = new BookView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void fillData() {
		 table.removeAll();
		for(Book p : pm.getAll()) {
			TableItem tableItem=new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] 
					{String.valueOf(p.getId_book()),p.getName(),p.getAuteur(),p.getAnnee()
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
		fillData();
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
			 Book mybook=pm.getOne(id);
			 textId_Book.setText(String.valueOf(mybook.getId_book()));
			 textNameBook.setText(mybook.getName());
			 textAuteur.setText(mybook.getAuteur());
			 textAnnee.setText(mybook.getAnnee());
			 
			}
		});
		table.setBounds(10, 10, 424, 97);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn idBookColumn = new TableColumn(table, SWT.NONE);
		idBookColumn.setWidth(100);
		idBookColumn.setText("idBook");
		
		TableColumn nameBookC = new TableColumn(table, SWT.NONE);
		nameBookC.setWidth(100);
		nameBookC.setText("nameBook");
		
		TableColumn auteurColumn = new TableColumn(table, SWT.NONE);
		auteurColumn.setWidth(100);
		auteurColumn.setText("auteur");
		
		TableColumn anneeColumn = new TableColumn(table, SWT.NONE);
		anneeColumn.setWidth(100);
		anneeColumn.setText("annee");
		
		TableItem tableItemEnregistrement = new TableItem(table, SWT.NONE);
		tableItemEnregistrement.setText("New TableItem");
		
		Button saveButton = new Button(shell, SWT.NONE);
		saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Book p=new Book();
				p.setName(textNameBook.getText());
				p.setAnnee(textAnnee.getText());
				p.setAuteur(textAuteur.getText());
				
				if(pm.save(p)) 
				{
					JOptionPane.showMessageDialog(null, "add succefully");
				}
				else JOptionPane.showMessageDialog(null, "failed");
			}
		});
		saveButton.setBounds(234, 119, 97, 34);
		saveButton.setText("Save");
		
		Button updateButton = new Button(shell, SWT.NONE);
		updateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			
			public void widgetSelected(SelectionEvent e) {
				
				Book p=new Book();
				p.setId_book(Integer.parseInt(textId_Book.getText()));
				p.setName(textNameBook.getText());
				p.setAnnee(textAnnee.getText());
				p.setAuteur(textAuteur.getText());
				if(pm.update(p)) {
					JOptionPane.showMessageDialog(null, "update succefully");
				}
				else JOptionPane.showMessageDialog(null, "failed while updating");
				
			}
		});
		updateButton.setBounds(234, 184, 97, 34);
		updateButton.setText("Update");
		
		Button DeleteButton = new Button(shell, SWT.NONE);
		DeleteButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int result =JOptionPane.showConfirmDialog(null, "are you sure?","confirme",JOptionPane.YES_NO_CANCEL_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					TableItem[] selection=table.getSelection();
					int id=Integer.parseInt(selection[0].getText());
					 Book p=pm.getOne(id);
					 pm.delete(p);
					 fillData();
				}
			}
		});
		DeleteButton.setBounds(337, 184, 97, 34);
		DeleteButton.setText("Delete");
		
		Button ReadButton_getAll = new Button(shell, SWT.NONE);
		ReadButton_getAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			fillData();	
			}});
		ReadButton_getAll.setBounds(337, 119, 97, 34);
		ReadButton_getAll.setText("Show");
		
		Label LabeltextIdBook = new Label(shell, SWT.NONE);
		LabeltextIdBook.setBounds(10, 119, 70, 17);
		LabeltextIdBook.setText("id_Book");
		
		textId_Book = new Text(shell, SWT.BORDER);
		textId_Book.setBounds(86, 113, 131, 30);
		
		Label lblNameBook = new Label(shell, SWT.NONE);
		lblNameBook.setBounds(10, 155, 70, 17);
		lblNameBook.setText("nameBook");
		
		textNameBook = new Text(shell, SWT.BORDER);
		textNameBook.setBounds(86, 149, 131, 30);
		
		textAuteur = new Text(shell, SWT.BORDER);
		textAuteur.setBounds(86, 188, 131, 30);
		
		Label lblAuteur = new Label(shell, SWT.NONE);
		lblAuteur.setBounds(10, 188, 70, 17);
		lblAuteur.setText("auteur");
		
		textAnnee = new Text(shell, SWT.BORDER);
		textAnnee.setBounds(86, 224, 131, 30);
		
		Label lblAnnee = new Label(shell, SWT.NONE);
		lblAnnee.setBounds(10, 224, 70, 17);
		lblAnnee.setText("annee");

	}
}
