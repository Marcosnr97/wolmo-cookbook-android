package ar.com.wolox.android.cookbook.coroutines

import ar.com.wolox.android.cookbook.R
import ar.com.wolox.android.cookbook.coroutines.core.fromHtml
import ar.com.wolox.android.cookbook.coroutines.model.Competition
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import kotlinx.android.synthetic.main.fragment_coroutines_login.*
import javax.inject.Inject

class CoroutinesRecipeFragment : WolmoFragment<CoroutinesRecipePresenter>(), CoroutinesRecipeView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

    override fun layout() = R.layout.fragment_coroutines_login

    override fun init() {
    }

    override fun showCompetition(competition: Competition) {
        competitionName.text = competition.name
        teamsList.text = competition.teams.joinToString("<br><br>") {
            it.name + ":<br>-" + it.squad?.joinToString("<br>-") { player -> "${player.name} - ${player.position}" }
        }.fromHtml()
    }

    override fun showEmptyAuthorError() = toastFactory.show(R.string.coroutines_empty_author_error)

    companion object {

        private const val SHOW_BOOK_FORMAT = "%s<br>%s<br><br><br><br>%s<br>"

        fun newInstance() = CoroutinesRecipeFragment()
    }
}