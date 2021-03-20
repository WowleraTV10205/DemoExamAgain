package org.brovushka.app.ui;

import org.brovushka.app.entity.ProductEntity;
import org.brovushka.app.manager.ProductEntityManager;
import org.brovushka.app.util.BaseForm;
import org.brovushka.app.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class ProductTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;

    public ProductTableForm()
    {
        setContentPane(mainPanel);

        this.initTable();

        setVisible(true);
    }

    private void initTable()
    {
        try {
            table.setModel(new CustomTableModel<ProductEntity>(
                    ProductEntity.class,
                    new String[] { "ID", "Название", "Цена", "Описание", "Картинка", "Активен?", "Производитель" },
                    ProductEntityManager.getAll()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
