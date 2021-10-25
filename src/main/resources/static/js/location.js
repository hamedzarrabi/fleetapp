/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			
			$('#idEdit').val(location.id);
			$('#nameEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStatesEdit').val(location.stateid);
			$('#detailsEdit').val(location.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (location, status) {
			$('#idDetails').val(location.id);
			$('#ddlCountryDetails').val(location.countryid);
			$('#nameDetails').val(location.description);
			$('#addressDetails').val(location.address);
			$('#countryDetails').val(location.country);
			$('#detailsDetails').val(location.details);
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
$