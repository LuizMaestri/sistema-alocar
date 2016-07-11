from  os import walk, system, path

for root, _, files in walk('.'):
    collection = root.replace('.', '').replace('\', '')
    if len(collection) is not 0:
        collection = collection[0].upper() + collection[1:-1] + collection[-1]
        for file in files:
            cmd = 'mongoimport --db ALOCAR --collection %s %s --jsonArray --drop' % (
                collection if 'id' not in file else 'id_' + collection,
                path.join(root, file)
            )
            system(cmd)
