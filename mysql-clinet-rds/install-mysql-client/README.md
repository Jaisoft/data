ansible all -m ping --private-key=/Users/jaisoft/ansible-kp/ssh_test_kp.pem


ansible-playbook mysql-client.yml --private-key=/Users/jaisoft/ansible-kp/ssh_test_kp.pem

ssh -i /Users/jaisoft/ansible-kp/ssh_test_kp.pem ubuntu@15.188.62.78

mysql -h rds-mysql.cwmby7b20ozw.eu-west-3.rds.amazonaws.com -P 3306 -u admin123 -p

pass: admin123


mysql commands  =  https://dev.mysql.com/doc/mysql-getting-started/en/




