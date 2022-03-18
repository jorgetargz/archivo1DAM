for i in $(last -w | tr -s ' ' | grep -v reboot| grep -v wtmp | cut -d' ' -f1 | sort -rn | uniq -c | tr -s ' ' | sort -rn | cut -d' ' -f3) ;
do
echo -n $(last -w | tr -s ' ' | grep -w $i | cut -d' ' -f1 | sort -rn | uniq -c | tr -s ' ');
echo -n " ";
echo $(groups $i | cut -d ':' -f2);
done
