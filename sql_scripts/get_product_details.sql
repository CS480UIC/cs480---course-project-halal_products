CREATE DEFINER=`root`@`localhost` PROCEDURE `get_product_details`(
	region_name_param varchar(100)
)
BEGIN
	Select *
    From product_detail pd
    Where pd.region_name like concat('%', region_name_param, '%')
    Order By pd.product_name, pd.store_name, pd.region_name;
END