package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationStyleFactory;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;

import java.util.ArrayList;
import java.util.List;

public class ListView
  extends LazyReverseView<IListView.Presenter>
  implements IListView {

  private ScrollPanel       panel;
  private CellTable<Person> resultTable;
  private ApplicationCss    style;

  public ListView() {
    super();
    
    this.style = ApplicationStyleFactory.get().getStyle();
  }

  @Override
  public void resetTable() {
    // Row-Count zurück setzen
    resultTable.setRowCount(0, true);
    // Mit leerer Liste fuellen ... Brauch man das wirklich ... ?????
    resultTable.setRowData(0, new ArrayList<Person>());
  }

  @Override
  public void setData(List<Person> result) {
    resultTable.setRowData(result);
  }

  public void createView() {
    panel = new ScrollPanel();
    
    FlowPanel resultPanel = new FlowPanel();
    resultPanel.addStyleName(style.resultPanel());
    panel.add(resultPanel);
    
    Label headline = new Label(ApplicationConstants.CONSTANTS.resultHeadline());
    headline.addStyleName(style.headline());
    resultPanel.add(headline);
    
    resultTable = new CellTable<Person>();
    resultPanel.add(resultTable);
    resultTable.setEmptyTableWidget(new HTML(ApplicationConstants.CONSTANTS.resultText()));
    Column<Person, String> nameColumn = addColumn(new ClickableTextCell(),
                                                  ApplicationConstants.CONSTANTS.columnName(),
                                                  new GetValue<String>() {
                                                    @Override
                                                    public String getValue(Person person) {
                                                      return person.getName() + ", " + person.getFirstName();
                                                    }
                                                  },
                                                  new FieldUpdater<Person, String>() {
                                                    @Override
                                                    public void update(int index, Person object, String value) {
                                                      getPresenter().doUpdate(object);
                                                    }
                                                  });
    
    Column<Person, String> streetColumn = addColumn(new TextCell(),
                                                    ApplicationConstants.CONSTANTS.columnStreet(),
                                                    new GetValue<String>() {
                                                      @Override
                                                      public String getValue(Person person) {
                                                        return person.getAddress().getStreet();
                                                      }
                                                    },
                                                    null);

    Column<Person, String> plzColumn = addColumn(new TextCell(),
                                                 ApplicationConstants.CONSTANTS.columnPlz(),
                                                 new GetValue<String>() {
                                                   @Override
                                                   public String getValue(Person person) {
                                                     return person.getAddress().getZip();
                                                   }
                                                 },
                                                 null);
    plzColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

    Column<Person, String> cityColumn = addColumn(new TextCell(),
                                                  ApplicationConstants.CONSTANTS.columnCity(),
                                                  new GetValue<String>() {
                                                      @Override
                                                      public String getValue(Person person) {
                                                        return person.getAddress().getCity();
                                                      }
                                                    },
                                                  null);
  
    // Tabellen und Spalten-Breite setzen
    resultTable.setWidth("100%");
    resultTable.setColumnWidth(nameColumn, "40%");
    resultTable.setColumnWidth(streetColumn, "25%");
    resultTable.setColumnWidth(plzColumn, "10%");
    resultTable.setColumnWidth(cityColumn, "25%");

    resetTable();
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  /**
   * Get a cell value from a record.
   *
   * @param <C> the cell type
   */
  private interface GetValue<C> {
    C getValue(Person person);
  }

  /**
   * Add a column with a header.
   *
   * @param <C> the cell type
   * @param cell the cell used to render the column
   * @param headerText the header string
   * @param getter the value getter for the cell
   */
  private <C> Column<Person, C> addColumn(Cell<C> cell,
                                          String headerText,
                                          final GetValue<C> getter,
                                          FieldUpdater<Person, C> fieldUpdater) {
    Column<Person, C> column = new Column<Person, C>(cell) {
      @Override
      public C getValue(Person object) {
        return getter.getValue(object);
      }
    };
    column.setFieldUpdater(fieldUpdater);
    resultTable.addColumn(column, headerText);
    return column;
  }
}
