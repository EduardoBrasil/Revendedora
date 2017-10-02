require_relative 'jequitiEnterprise'
require_relative 'MaryKayEnterprise'
require_relative 'BoticarioEnterprise'

class FactoryCatalog < ApplicationRecord
	belongs_to :enterprise 
	has_many :category
	def getCatalog(type)
		case type
			when 'JequitiEnterprise' then JequitiCatalog.new
			when 'MaryKayEnterprise' then MarykayCatalog.new
			when 'BoticarioEnterprise' then BoticarioCatalog.new 	
		end
 	end
end