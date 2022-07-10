
for led_control_data in led_control_data_list:
    if led_control_data['storeCode'] in led_control_dict_by_store_code:
        led_control_dict_by_store_code[led_control_data['storeCode']]['product'].append(
            led_control_data['product'])
else:
    led_control_dict_by_store_code[led_control_data['storeCode']] = {
        'storeCode': led_control_data['storeCode'],
        'product': [led_control_data['product']]
    }
for store_code, json_data in led_control_dict_by_store_code.items():
    pr_code_list = list(pr_code_set_by_store[store_code])
    tag_mac_list = get_tag_mac_list_by_pr_code(store_code, pr_code_list)
    if tag_mac_list:
        logging.info("led control - tag mac [{}]".format(tag_mac_list))
        requests.post('http://' + SERVER_URL + '/api/tag/led', json=json_data)