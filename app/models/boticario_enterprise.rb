require_relative 'enterprise'

class BoticarioEnterprise < Enterprise

	def getCatalog
		puts BoticarioEnterprise::getCatalog().getCatalog
	end
end
