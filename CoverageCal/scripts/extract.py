"""
Extract test methods and write into java files from repo.json
"""

import os
import json

json_dir = '/Users/chenyixuan/Downloads/Coverage/json'
output_dir = '/Users/chenyixuan/Downloads/Coverage/ProjectResult'

def extract(repo):
    results = []
    json_fpath = os.path.join(json_dir, repo + '.json')
    # final_json_fpath = os.path.join(json_dir, repo + '_final_result.json')

    # final_datas = json.load(open(final_json_fpath, 'r'))
    datas = json.load(open(json_fpath, 'r'))


    for data in datas:
        code = data['Under_test_method']['Class_declaration'] + \
                data['Under_test_method']['Method_body'] + \
                data['Under_test_method']['all_method_signature'] + \
                data['Under_test_method']['public_field']

        results.append({
            "code": code,
            "test": "",
            "focal_method": data['Under_test_method']['project_path']# os.path.join(repo, focal_method_data['Under_test_method']['project_path'].split(repo + '/')[1])
        })

    with open(os.path.join(output_dir, f'{repo}_input.jsonl'), 'w') as f:
        for r in results:
            json.dump(r, f)
            f.write('\n')


if __name__ == '__main__':
    repos = ['GoSimpleLLC_nbvcxz', 'sachin-handiekar_jInstagram', 'tabulapdf_tabula-java', 'Zappos_zappos-json']
    for repo in repos:
        extract(repo)