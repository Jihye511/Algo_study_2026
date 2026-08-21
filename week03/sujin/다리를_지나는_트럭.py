from collections import deque

def solution(bridge_length, weight, truck_weights):
    trucks = deque(truck_weights)
    bridge = deque([0] * bridge_length)

    time = 0
    cur_weight = 0

    while trucks:
        time += 1

        cur_weight -= bridge.popleft()

        if cur_weight + trucks[0] <= weight:
            truck = trucks.popleft()
            bridge.append(truck)
            cur_weight += truck
        else:
            bridge.append(0)

    return time + bridge_length