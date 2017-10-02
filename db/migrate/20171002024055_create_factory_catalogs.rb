class CreateFactoryCatalogs < ActiveRecord::Migration[5.1]
  def change
    create_table :factory_catalogs do |t|

      t.timestamps
    end
  end
end
