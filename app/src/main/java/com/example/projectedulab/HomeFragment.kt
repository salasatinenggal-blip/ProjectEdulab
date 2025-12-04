class HomeFragment : Fragment() {

    private lateinit var adapter: LaporanAdapter
    private lateinit var dataList: ArrayList<Laporan>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.rvLaporan)
        val edtSearch = view.findViewById<EditText>(R.id.edtSearch)

        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        dataList = arrayListOf(
            Laporan("Laporan Praktikum Basis Data", "18 Pages", R.drawable.ic_file),
            Laporan("Laporan Praktikum Jaringan", "28 Pages", R.drawable.ic_file),
            Laporan("Laporan Praktikum Manajemen", "30 Pages", R.drawable.ic_file),
            Laporan("Laporan Praktikum Matematika", "14 Pages", R.drawable.ic_file),
        )

        adapter = LaporanAdapter(dataList)
        rv.adapter = adapter

        // SEARCH FILTER
        edtSearch.addTextChangedListener {
            val keyword = it.toString().lowercase()
            val filtered = dataList.filter {
                it.judul.lowercase().contains(keyword)
            }
            adapter.updateList(filtered)
        }
    }
}
