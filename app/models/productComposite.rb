Class Product < ProductComposite

    def initializer(name)
        super.('Product product')
        @category = []

        self << ProductComposite.new
    end
end
