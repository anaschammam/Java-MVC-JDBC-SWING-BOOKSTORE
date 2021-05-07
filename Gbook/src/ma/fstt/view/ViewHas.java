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
import ma.fstt.dao.Base_has;
import ma.fstt.model.Book;
import ma.fstt.model.BookStore;
import ma.fstt.model.Has;
import org.eclipse.swt.widgets.Button;

public class ViewHas {

	protected Shell shell;
	private Table table;
	private Text text_id_has;
	private Text text_date_has;
	private Text text_id_book_foreign;
	private Text text_id_bookstore_foreign;
	private Base_has own=new Base_has();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ViewHas window = new ViewHas();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void fillData() {
		 table.removeAll();
			for(Has p : own.getAll_join()) {
				TableItem tableItem=new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] 
						{
								String.valueOf(p.getId_has()),
								p.getDate(),String.valueOf(p.getBook().getId_book()),
								String.valueOf(p.getBookStore().getId_bookstore())
										,p.getBook().getName(),
										p.getBookStore().getName()
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
			 Has myownership=own.getOne(id);
			text_id_has.setText(String.valueOf(myownership.getId_has()));
			 text_date_has.setText(myownership.getDate());
			 text_id_book_foreign.setText(String.valueOf(myownership.getBook().getId_book()));
			 text_id_bookstore_foreign.setText(String.valueOf(myownership.getBookStore().getId_bookstore()));
			 
			}
		});
		table.setBounds(10, 10, 424, 86);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn Id_Has_Column = new TableColumn(table, SWT.NONE);
		Id_Has_Column.setWidth(58);
		Id_Has_Column.setText("id_has");
		
		TableColumn Date_hasColumn = new TableColumn(table, SWT.NONE);
		Date_hasColumn.setWidth(79);
		Date_hasColumn.setText("date_has");
		
		TableColumn id_book_Column = new TableColumn(table, SWT.NONE);
		id_book_Column.setWidth(69);
		id_book_Column.setText("id_book");
		
		TableColumn idBookStoreColumn = new TableColumn(table, SWT.NONE);
		idBookStoreColumn.setWidth(50);
		idBookStoreColumn.setText("id_bookstore");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(78);
		tblclmnNewColumn.setText("nameb");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(78);
		tblclmnNewColumn_1.setText("namebs");
		
		Label id_has_Label = new Label(shell, SWT.NONE);
		id_has_Label.setBounds(10, 102, 70, 17);
		id_has_Label.setText("id_has");
		
		Label date_has_Label = new Label(shell, SWT.NONE);
		date_has_Label.setBounds(10, 136, 70, 17);
		date_has_Label.setText("date_has");
		
		Label id_book_Label = new Label(shell, SWT.NONE);
		id_book_Label.setBounds(10, 173, 70, 17);
		id_book_Label.setText("id_book");
		
		Label id_bookstore_Label = new Label(shell, SWT.NONE);
		id_bookstore_Label.setBounds(10, 215, 96, 17);
		id_bookstore_Label.setText("id_bookstore");
		
		text_id_has = new Text(shell, SWT.BORDER);
		text_id_has.setBounds(112, 102, 129, 30);
		
		text_date_has = new Text(shell, SWT.BORDER);
		text_date_has.setBounds(112, 137, 129, 30);
		
		text_id_book_foreign = new Text(shell, SWT.BORDER);
		text_id_book_foreign.setBounds(112, 173, 129, 30);
		
		text_id_bookstore_foreign = new Text(shell, SWT.BORDER);
		text_id_bookstore_foreign.setBounds(112, 215, 129, 30);
		
		Button btnSave = new Button(shell, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Has p=new Has();
				Book ownaBook =new Book();
				BookStore ownBookStore=new BookStore();
				p.setId_has(Integer.parseInt(text_id_has.getText()));
				p.setDate(text_date_has.getText());
				ownaBook.setId_book(Integer.parseInt(text_id_book_foreign.getText()));
				p.setBook(ownaBook);
				ownBookStore.setId_bookstore(Integer.parseInt(text_id_bookstore_foreign.getText()));
				p.setBookStore(ownBookStore);
				
				if(own.save(p)) 
				{
					JOptionPane.showMessageDialog(null, "add succefully");
					

				}
				else JOptionPane.showMessageDialog(null, "failed");
				 table.clearAll();
				 fillData();
			}
		});
		btnSave.setBounds(247, 102, 85, 34);
		btnSave.setText("Save");
		
		Button btnUpdate = new Button(shell, SWT.NONE);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Has p=new Has();
				Book ownaBook =new Book();
				BookStore ownBookStore=new BookStore();
				p.setId_has(Integer.parseInt(text_id_has.getText()));
				p.setDate(text_date_has.getText());
				ownaBook.setId_book(Integer.parseInt(text_id_book_foreign.getText()));
				p.setBook(ownaBook);
				ownBookStore.setId_bookstore(Integer.parseInt(text_id_bookstore_foreign.getText()));
				p.setBookStore(ownBookStore);
				
				if(own.update(p)) 
				{
					JOptionPane.showMessageDialog(null, "update succefully");
					

				}
				else JOptionPane.showMessageDialog(null, "failed while Updating");
				 table.clearAll();
				 fillData();
			}
			
		});
		btnUpdate.setBounds(247, 156, 85, 34);
		btnUpdate.setText("Update");
		
		Button btnShow = new Button(shell, SWT.NONE);
		btnShow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.clearAll();
				 fillData();
				 //getAll_join
			}
		});
		btnShow.setBounds(337, 102, 97, 34);
		btnShow.setText("Show");
		
		Button btnDelete = new Button(shell, SWT.NONE);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int result =JOptionPane.showConfirmDialog(null, "are you sure?","confirme",JOptionPane.YES_NO_CANCEL_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					TableItem[] selection=table.getSelection();
					int id=Integer.parseInt(selection[0].getText());
					 Has p=own.getOne(id);
					 table.clearAll();
					 own.delete(p);
					 fillData();
			}
			}
		});
		btnDelete.setBounds(337, 156, 97, 34);
		btnDelete.setText("Delete");

	}

}
