/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(supplier, status){
			
			$('#idEdit').val(supplier.id);
			$('#nameEdit').val(supplier.description);
			$('#cityEdit').val(supplier.city);
			$('#addressEdit').val(supplier.address);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#ddlStatesEdit').val(supplier.stateid);
			$('#detailsEdit').val(supplier.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (supplier, status) {
			$('#idDetails').val(supplier.id);
			$('#ddlCountryDetails').val(supplier.countryid);
			$('#nameDetails').val(supplier.description);
			$('#addressDetails').val(supplier.address);
			$('#countryDetails').val(supplier.country);
			$('#detailsDetails').val(supplier.details);
		});
		$('#detailsModal').modal();
	});
	
	
	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
	
});
