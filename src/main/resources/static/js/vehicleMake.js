/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehicleMake, status){
			
			$('#idEdit').val(vehicleMake.id);
			$('#nameEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (vehicleMake, status) {
			
			$('#idDetails').val(vehicleMake.id);
			$('#nameDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
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