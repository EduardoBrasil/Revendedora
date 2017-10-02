class CreateProductComposites < ActiveRecord::Migration[5.1]
  def change
    create_table :product_composites do |t|
      t.string :name
      t.text :description
      t.integer :quantity
      t.decimal :price

      t.timestamps
    end
  end
end
