import os.path
import sys
import re


def coordinates_input(data, coord, position):
    # [0] = direction (L)
    # [1] = blocks (12)

    for i in data:
        split_dir = re.findall('\d+|\D+',i)

        if position == "Up":
            if split_dir[0] == "L":
                coord[0] -= int(split_dir[1])
                position = "Left"
            elif split_dir[0] =="R":
                coord[0] += int(split_dir[1])
                position = "Right"
        elif position == "Down":
            if split_dir[0] == "L":
                coord[0] += int(split_dir[1])
                position = "Right"
            elif split_dir[0] == "R":
                coord[0] -= int(split_dir[1])
                position = "Left"
        elif position == "Right":
            if split_dir[0] == "L":
                coord[1] += int(split_dir[1])
                position = "Up"
            elif split_dir[0] == "R":
                coord[1] -= int(split_dir[1])
                position = "Down"
        elif position == "Left":
            if split_dir[0] == "L":
                coord[1] -= int(split_dir[1])
                position = "Down"
            elif split_dir[0] == "R":
                coord[1] += int(split_dir[1])
                position = "Up"

def open_file():
    file_name = "input"
    if os.path.isfile(file_name) == False:
        print "File does not exist"
        sys.exit()
    with open('input', 'r') as my_file:
        output = my_file.read()
    data = re.split(', ', output)

    return data

def calc_blocks(data):
    return data[0] + data[1]

def visited_loc_prev(prev_loc, current_loc):
    if current_loc in prev_loc:
        return True
    else:
        return False

def add_to_coordinates(coord, steps, sign):



def main():
    coord = [0,0]
    position = "Up"

    data = open_file()
    coordinates_input(data, coord, position)

    print calc_blocks(coord)

if __name__ == "__main__":
    main()
