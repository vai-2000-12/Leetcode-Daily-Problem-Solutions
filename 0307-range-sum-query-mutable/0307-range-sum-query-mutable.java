class NumArray {

    int[] nums;      // Original array
    int[] blocks;    // Har block ka sum store karega
    int n;           // Array ka size
    int blockSize;   // Ek block me kitne elements honge

    public NumArray(int[] nums) {

        // Original array ko store kar lo
        this.nums = nums;
        n = nums.length;

        // Block size = √n
        blockSize = (int) Math.sqrt(n);

        // Agar array khali ho to block size 1 rakh do
        if (blockSize == 0)
            blockSize = 1;

        // Total kitne blocks lagenge
        blocks = new int[(n + blockSize - 1) / blockSize];

        // Har element ko uske corresponding block ke sum me add karo
        for (int i = 0; i < n; i++) {
            blocks[i / blockSize] += nums[i];
        }
    }

    public void update(int index, int val) {

        // Pata karo ye element kis block me hai
        int block = index / blockSize;

        // Purani value aur nayi value ka difference nikal lo
        int diff = val - nums[index];

        // Sirf usi block ke sum ko update karna padega
        blocks[block] += diff;

        // Original array bhi update kar do
        nums[index] = val;
    }

    public int sumRange(int left, int right) {

        int sum = 0;

        // ---------------- Left Partial Block ----------------
        // Jab tak left kisi block ke start par nahi aata,
        // tab tak ek-ek element add karte jao.
        while (left <= right && left % blockSize != 0) {
            sum += nums[left];
            left++;
        }

        // ---------------- Complete Blocks ----------------
        // Agar pura block range ke andar aa raha hai,
        // to us block ka stored sum direct add kar do.
        while (left + blockSize - 1 <= right) {
            sum += blocks[left / blockSize];
            left += blockSize;
        }

        // ---------------- Right Partial Block ----------------
        // End me jo kuch elements bach gaye hain,
        // unko individually add kar lo.
        while (left <= right) {
            sum += nums[left];
            left++;
        }

        return sum;
    }
}