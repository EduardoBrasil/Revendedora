class Category < ApplicationRecord
belongs_to :catalog
has_many :productComposite
end
