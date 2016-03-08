import os, json

for (dirpath, dirname, filenames) in os.walk('./blockdude/resources/levels'):
	for filename in filenames:
		if not filename.endswith('.json'):
			continue

		f = json.load(open(dirpath+'/'+filename, 'r'))
		matrix = f['matrix']
		matrix = zip(*matrix)
		name = filename.replace('.json', '').replace('lev','')
		if len(name) == 1:
			name = '0'+name
		o = open(dirpath+'/'+name, 'w')
		o.write(f['name']+'\n')
		for line in matrix:
			o.write(','.join(map(str, list(line)))+'\n')
