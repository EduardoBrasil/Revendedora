require_relative 'enterprise'

class JequitiEnterprise < Enterprise

	def getCatalog
		Enterprise.new(JequitiEnterprise)
	end
end