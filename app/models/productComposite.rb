ProductComposite < AppicationRecord
belongs_to :category

  def initializer(name)
    super(name)
    @category =[]
  end

  def getCategory(name)
    super(name)
    @product =[]
  end

  def add_Category(category)
    @product << product
    product.parent = self
  end

  alias << add_Category

  def remove_Category(category)
    @category.delete(category)
    task.parent = nil
  end

  def [] (index, value)
    replace_value = @category[index]
    @category[index] = value
    replace_value.parent = nil
    value.parent = self
  end
end
