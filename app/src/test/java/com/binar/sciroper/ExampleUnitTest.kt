package com.binar.sciroper

import com.binar.sciroper.data.db.user.User
import com.binar.sciroper.util.AvatarHelper
import com.binar.sciroper.util.UserLevel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var user: User
    private lateinit var userLevel: UserLevel
    private lateinit var users: List<User>

    @Before
    fun setup() {
        user = User(
            1, "Riski", "riski@gmail.com", "riski123", AvatarHelper.avatarId1, 3, 1, 5, 90
        )

        users = listOf(
            User(
                1, "Riski", "riski@gmail.com", "riski123", AvatarHelper.avatarId1, 3, 1, 5, 90
            ),
            User(
                2, "Riskia", "riskia@gmail.com", "riski123a", AvatarHelper.avatarId2, 3, 1, 2, 91
            ),
            User(
                3, "Riskib", "riskib@gmail.com", "riski123b", AvatarHelper.avatarId3, 3, 1, 5, 90
            ),
            User(
                4, "Riskic", "riskic@gmail.com", "riski123c", AvatarHelper.avatarId4, 3, 1, 7, 25
            )
        )

        userLevel = UserLevel(user)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun avatarHelper_isCorrect() {
        assert( AvatarHelper.avatarId3 == R.drawable.avatar3 )
    }

    @Test
    fun userLevelWin_isCorrect(){
        userLevel.win()
        assert( user.point == 15 && user.level == 6)
    }

    @Test
    fun userLevelLose_isCorrect(){
        userLevel.lose()
        assert( user.point == 35 )
    }

    @Test
    fun userLevelSortUsers_isCorrect(){
        UserLevel.sortUsersLevel(users)

        assert( users[3].id == 2 )
    }

}