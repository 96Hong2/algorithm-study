from collections import Counter

while True:
    n, m = map(int, input().split())

    if n == 0 and m == 0:
        break

    rank = Counter()
    for _ in range(n):
        rank.update(list(map(int, input().split())))

    _, championship_wins = rank.most_common()[0]

    for _, win in rank.most_common()[1:]:
        if win == championship_wins:
            pass
        else:
            runner_up_wins = win
            break

    player_lst = []
    for player, win in rank.most_common()[1:]:
        if win == championship_wins:
            pass
        elif win == runner_up_wins:
            player_lst.append(player)
        else:
            break

    print(*sorted(player_lst))