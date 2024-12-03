cd C:/hse/курсовая # путь можно свой, это то где будет проект
git clone https://github.com/annabaurina/hse-project.git 
ls #покажет какие тут файлы, нужно чтоб проверить склонировалось ли
cd hse-project # переходите в репозиторий (копировать без изменений)
git branch {branch_name} #создаете свою ветку, вместо {branch_name} - имя ветки без {}
git checkout {branch_name} #переходите на свою ветку, вместо {branch_name} - имя ветки без {}

#how to commit:
git add . #говорите что коммитить надо вооообще все файлы
git commit -m "{commit's name}" # вместо {commit's name} - имя коммита без {}
git push # коммитите и на сервере тоже, иначе коммит будет только у вас на компе в локальном репозитории
# or
git push --set-upstream origin {branch_name} # на случай если просто git push не работает



