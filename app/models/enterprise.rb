class Enterprise < ApplicationRecord
belongs_to :consultant
has_one :catalog

	def getCatalog
		raise 'must implement getCatalog() method in subclass'
	end
end
